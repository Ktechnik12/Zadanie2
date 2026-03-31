val ScalatraVersion = "3.1.2"

ThisBuild / scalaVersion := "3.3.7"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "shop-api",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
      "org.scalatra" %% "scalatra-json-jakarta" % ScalatraVersion,
      "org.json4s" %% "json4s-jackson" % "4.0.7",
      "ch.qos.logback" % "logback-classic" % "1.5.19" % Runtime,
      "org.eclipse.jetty.ee10" % "jetty-ee10-webapp" % "12.0.20"
    ),
  )

enablePlugins(SbtTwirl)
enablePlugins(SbtWar)

Test / fork := true
