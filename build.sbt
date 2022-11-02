val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "prueba",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.3",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
    
  )
