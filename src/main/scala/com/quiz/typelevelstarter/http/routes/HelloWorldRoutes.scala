package com.quiz.typelevelstarter.http.routes

import cats.Monad
import cats.implicits._
import com.quiz.typelevelstarter.algebras.HelloWorldAlg
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router

class HelloWorldRoutes[F[_]: Monad] private(helloWorldAlg: HelloWorldAlg[F]) extends Http4sDsl[F] {
  private val helloWorldRoute: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / name =>
      for {
        greeting <- helloWorldAlg.hello(HelloWorldAlg.Name(name))
        resp     <- Ok(greeting)
      } yield resp
  }

  val routes: HttpRoutes[F] = Router(
    "/hello" -> helloWorldRoute
  )
}

object HelloWorldRoutes {
  def apply[F[_]: Monad](helloWorldAlg: HelloWorldAlg[F]): HelloWorldRoutes[F] = new HelloWorldRoutes[F](helloWorldAlg)
}
