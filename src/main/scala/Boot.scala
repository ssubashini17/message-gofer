package com.messenger;

import akka.actor.{ActorSystem, Props}
import akka.event.Logging
import akka.io.IO
import spray.can.Http

object Boot extends App with MySslConfiguration {
  implicit val system  = ActorSystem("messenger-service")
  val log = Logging(system, getClass)

  val service = system.actorOf(Props[MessengerActor], "spray-service")
  IO(Http) ! Http.Bind(service, interface = "localhost", port = AppConfig.getHttpPort)
}
