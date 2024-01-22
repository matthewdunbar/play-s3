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
    organization := "com.lifeway.cp",
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

resolvers ++= Seq(
  Resolver.url("Typesafe Ivy releases", url("https://repo.typesafe.com/typesafe/ivy-releases"))(Resolver.ivyStylePatterns),
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
  "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases",
  "Maven Lib" at "https://mvnrepository.com/artifact/",
  DefaultMavenRepository,
  "Java.net Maven2 Repository" at "https://download.java.net/maven/2/",
  Resolver.jcenterRepo,
  Resolver.bintrayRepo("dwhjames", "maven"),
  "Lifeway Repo External Libs" at "https://artifactory.prod.lifeway.com/artifactory/ext-release-local/",
  "Lifeway Repo Internal Libs" at "https://artifactory.prod.lifeway.com/artifactory/libs-release-local/"
)

scalacOptions ++= Seq("-feature", "-deprecation")

parallelExecution in Test := false
