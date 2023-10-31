name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  // graalvm
  .enablePlugins(GraalVMNativeImagePlugin)
  .settings(
    PlayKeys.externalizeResources := false,
    graalVMNativeImageOptions ++= Seq(
      "-J-Xmx10G",
      "--enable-http",
      "--install-exit-handlers",
      "--no-fallback",
      s"-H:ResourceConfigurationFiles=${sys.props("user.dir")}/resource-config.json",
      s"-H:ReflectionConfigurationFiles=${sys.props("user.dir")}/reflect-config.json"
    )
  )

scalaVersion := "2.13.12"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

