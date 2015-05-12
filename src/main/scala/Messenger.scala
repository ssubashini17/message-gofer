package com.messenger;

import akka.actor.{Actor, Props}
import akka.event.Logging
import spray.routing._
import spray.http._
import MediaTypes._

class MessengerActor extends Actor with MessengerService {
  def actorRefFactory = context
  def receive = runRoute(messageRoute)
}

trait MessengerService extends HttpService {
  val messageRoute = 
    path("messages") {
      get {
	      complete {
          "Hello buddy, I'm running on port " + AppConfig.getHttpPort
	      }
	    }
    }
}

