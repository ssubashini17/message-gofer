package com.messenger;

import java.security.{SecureRandom, KeyStore}
import javax.net.ssl.{KeyManagerFactory, SSLContext, TrustManagerFactory}
import spray.io._
import org.apache.camel.util.jsse._

trait MySslConfiguration {

  implicit def sslContext: SSLContext = {
    val keyStoreResource = sys.props.get("keystore")
    val password = sys.props.get("password")
    val keyStoreParam = new KeyStoreParameters()
    keyStoreParam.setResource(keyStoreResource)
    keyStoreParam.setPassword(password)

    val keyManagerParam = new KeyManagersParameters()
    keyManagerParam.setKeyStore(keyStoreParam)
    keyManagerParam.setKeyPassword(password)

    val scp = new SSLContextParameters()
    scp.setKeyManagers(keyManagerParam)
    val context = scp.createSSLContext()
    context
  }
}