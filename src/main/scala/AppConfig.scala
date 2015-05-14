package com.messenger;
import com.typesafe.config.ConfigFactory

object AppConfig {
	private val config = ConfigFactory.load()

	object HttpConfig {
		private val httpConfig = config.getConfig("spray.can.server.http")
		lazy val port = httpConfig.getInt("port")
	}

	def getHttpPort() = HttpConfig.port
	def getHostname() = config.getString("spray.can.server.hostname")
}