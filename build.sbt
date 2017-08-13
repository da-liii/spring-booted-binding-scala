
resolvers += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"
resolvers += "aliyun" at "http://maven.aliyun.com/nexus/content/groups/public"

scalaVersion := "2.12.3"
javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

lazy val springBootVersion = "1.5.6.RELEASE"
lazy val jQueryV = "2.1.3"
lazy val semanticV = "2.2.2"

lazy val server = (project in file("server")).settings(
  name := "spring-boot-with-binding",
  organization := "com.sadhen.spring.boot",
  version := "1.0",
  libraryDependencies ++= Seq(
    "org.springframework.boot" % "spring-boot" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion,
    "org.springframework.boot" % "spring-boot-autoconfigure" % springBootVersion,
    "org.springframework.boot" % "spring-boot-starter-logging" % springBootVersion,
    "org.log4s" %% "log4s" % "1.3.4",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.7",
    "org.json4s" %% "json4s-jackson" % "3.5.1",
    "org.webjars" % "jquery" % jQueryV,
    "org.webjars" % "Semantic-UI" % semanticV,
    "org.scalatest" %% "scalatest" % "3.0.1" % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % Test
  ),
  mainClass := Some("com.sadhen.spring.boot.Application")
).enablePlugins(JavaAppPackaging)
