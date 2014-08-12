name := "My Project"
     
version := "1.0-SNAPSHOT"
     
scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  // test
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  //log
  "com.typesafe.akka" %% "akka-actor" % "2.3.4",
  "com.typesafe.akka" %% "akka-kernel" % "2.3.4",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.4" % "test"
)

