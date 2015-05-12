name := "MessageGopher"

version := "0.1"

scalaVersion := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

fork := true

javaOptions := Seq("-Dmx=1024M")

libraryDependencies ++= {
  val sprayVersion = "1.2-M8"
  val akkaVersion = "2.2.0-RC1"
  Seq(
  "io.spray" % "spray-can" % sprayVersion,
  "io.spray" % "spray-routing" % sprayVersion,
  "io.spray" % "spray-testkit" % sprayVersion,
  "io.spray" % "spray-client" % sprayVersion,
  "io.spray" %% "spray-json" % "1.2.5",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.12",
  "org.scalatest" %% "scalatest" % "2.0.M7" % "test",
  "org.apache.camel" % "camel-scala" % "2.10.1",
  "com.typesafe" % "config" % "1.0.2"
  )
}
