name := """ScalaTutorial"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.sorm-framework" % "sorm" % "0.3.16",
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.2-1"
)

