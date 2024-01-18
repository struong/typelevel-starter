

lazy val root = (project in file("."))
  .settings(
    organization := "com.quiz",
    name         := "typelevel-starter",
    version      := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.12",
    libraryDependencies ++= Dependencies.all ,
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value.apply(x)
    }
  )
