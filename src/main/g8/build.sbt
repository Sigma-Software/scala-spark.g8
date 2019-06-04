import deps._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "$version$"

lazy val root = (project in file("."))
  .enablePlugins(RootProjectPlugin)
  .enablePlugins(CommandLineProjectPlugin)
  .settings(
    name := "$name;format="Camel"$",
    libraryDependencies ++=
      logging ++
      spark,
    mainClass in Compile := Some("$organization$.SparkPi"),
    dockerBaseImage := "gemelen/spark:2.4.3-2.12-2.8.5",
    dockerEntrypoint := Seq("bin/start.sh"),
  )
