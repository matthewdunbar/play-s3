val playVersion = "2.8.18"

publishTo := {
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("Artifactory Realm" at "https://artifactory.prod.lifeway.com/artifactory/libs-snapshot-local")
  else
    Some("Artifactory Realm" at "https://artifactory.prod.lifeway.com/artifactory/libs-release-local")
}

publishMavenStyle := true

lazy val root = (project in file("."))
  .settings(
    name := "play-s3",
    organization := "net.kaliber",
    scalaVersion := "2.13.10",
    version := playVersion,
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-ws"     % playVersion % "provided",
      "com.typesafe.play" %% "play-test"   % playVersion % "test",
      "com.typesafe.play" %% "play-specs2" % playVersion % "test",
      "org.scalatest" %% "scalatest" % "3.2.12" % "test",
      "com.typesafe.play" %% "play-ahc-ws" % playVersion % "test",
      "com.typesafe.play" %% "play-logback" % playVersion % "test",
      "commons-codec" % "commons-codec" % "1.11" % "provided",
      "com.typesafe.play" % "shaded-asynchttpclient" % "2.0.1" % "provided"
    )
  )

scalacOptions ++= Seq("-feature", "-deprecation")

parallelExecution in Test := false
