resolvers += Resolver.file("project-local", file("ivy2/local"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.16+8-3e5e2d4c+20220731-2217-SNAPSHOT")
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.13.1")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")
