import sbt._

object Dependencies {
  val Http4sVersion          = "0.23.25"
  val CirceVersion           = "0.14.6"
  val LogbackVersion         = "1.4.14"
  val MunitCatsEffectVersion = "1.0.7"
  val ScalaTestVersion       = "3.2.15"
  val DoobieVersion          = "1.0.0-RC1"
  val PureConfigVersion      = "0.17.2"
  val TestContainerVersion   = "1.17.6"
  val Log4catsVersion        = "2.5.0"

  val compile: Seq[ModuleID] =
    Seq(
      "org.http4s"            %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"            %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"            %% "http4s-circe"        % Http4sVersion,
      "org.http4s"            %% "http4s-dsl"          % Http4sVersion,
      "io.circe"              %% "circe-generic"       % CirceVersion,
      "org.tpolecat"          %% "doobie-core"         % DoobieVersion,
      "org.tpolecat"          %% "doobie-hikari"       % DoobieVersion,
      "org.tpolecat"          %% "doobie-postgres"     % DoobieVersion,
      "com.github.pureconfig" %% "pureconfig-core"     % PureConfigVersion,
      "org.typelevel"         %% "log4cats-slf4j"      % Log4catsVersion,
      "ch.qos.logback"         % "logback-classic"     % LogbackVersion % Runtime,
      "org.scalameta"          % "svm-subs"            % "101.0.0"
    )

  val test: Seq[ModuleID] = Seq(
    "org.tpolecat"      %% "doobie-scalatest" % DoobieVersion        % Test,
    "org.scalatest"     %% "scalatest"        % ScalaTestVersion     % Test,
    "org.typelevel"     %% "log4cats-noop"    % Log4catsVersion      % Test,
    "org.testcontainers" % "testcontainers"   % TestContainerVersion % Test,
    "org.testcontainers" % "postgresql"       % TestContainerVersion % Test
  )

  val all = compile ++ test
}
