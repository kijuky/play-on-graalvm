resolvers += Resolver.file("project-local", file("ivy2/local"))(Resolver.ivyStylePatterns)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, GraalVMNativeImagePlugin)
  .settings(
    // basic
    name := """play-on-graalvm""",
    organization := "com.example",
    version := "1.0-SNAPSHOT"
  )
  .settings(
    // compiler
    scalaVersion := "2.13.8"
  )
  .settings(
    // dependencies
    libraryDependencies ++= Seq(
      guice,
      "com.google.inject.extensions" % "guice-assistedinject" % "5.1.0"
    ),
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0"
    ).map(_ % Test)
  )
  .settings(
    // graalvm
    PlayKeys.externalizeResources := false,
    graalVMNativeImageOptions ++= Seq(
      "-J-Xmx10G",
      "--allow-incomplete-classpath",
      "--enable-http",
      "--install-exit-handlers",
      "--no-fallback",
      s"-H:ResourceConfigurationFiles=${sys.props("user.dir")}/resource-config.json",
      s"-H:ReflectionConfigurationFiles=${sys.props("user.dir")}/reflect-config.json"
    )
  )
