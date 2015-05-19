package com.messenger
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.GenericUrl
import com.google.api.services.calendar.CalendarScopes
import com.google.api.services.gmail.GmailScopes
import com.google.api.client.json.jackson2.JacksonFactory
import scala.collection.JavaConversions._
import java.io._

object GoogleServiceAccount {
    val SERVICE_ACCOUNT_EMAIL =  sys.props.get("service-account")
    val JSON_FACTORY = JacksonFactory.getDefaultInstance()
    val P12FILE = sys.props.get("p12file")
    val SERVICE_ACCOUNT_SCOPES = new java.util.ArrayList[String]()
    SERVICE_ACCOUNT_SCOPES.add(GmailScopes.GMAIL_COMPOSE)
    SERVICE_ACCOUNT_SCOPES.add(CalendarScopes.CALENDAR)

    def getCredential(): GoogleCredential = {
        val httpTransport = GoogleNetHttpTransport.newTrustedTransport()
        
        if(!P12FILE.exists){
            throw new IllegalStateException("File " + P12FILE.getPath + " does not exist")
        }
        try{
            return new GoogleCredential.Builder()
                            .setTransport(httpTransport)
                            .setJsonFactory(JSON_FACTORY)
                            .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                            .setServiceAccountScopes(SERVICE_ACCOUNT_SCOPES)
                            .setServiceAccountPrivateKeyFromP12File(P12FILE)
                            .build()
        } catch {
            case e: Exception => throw new IllegalStateException("Could not create Google OAUTH2 credential. \n Caused by" + e.getMessage)
        }
        
    }
}