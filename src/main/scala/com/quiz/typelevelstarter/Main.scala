package com.quiz.typelevelstarter

import cats.effect.{IO, IOApp}
import cats.syntax.all._
import com.comcast.ip4s._
import com.quiz.typelevelstarter.http.routes.HelloWorldRoutes
import com.quiz.typelevelstarter.modules.{Algebras, HttpApi}
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.typelevel.log4cats.Logger
import org.typelevel.log4cats.slf4j.Slf4jLogger

object Main extends IOApp.Simple {
  implicit val logger: Logger[IO] = Slf4jLogger.getLogger[IO]

  override def run: IO[Unit] = {
    val appResource = for {
      algebras <- Algebras[IO]
      httpApi <- HttpApi[IO](algebras)
      server <- EmberServerBuilder
        .default[IO]
        .withHost(ipv4"0.0.0.0")
        .withPort(port"8080")
        .withHttpApp(httpApi.endpoints.orNotFound)
        .build
    } yield server

    appResource.use(_ => IO.println("Server ready!") *> IO.never)
  }
}
