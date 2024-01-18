package com.quiz.typelevelstarter.modules

import cats._
import cats.effect.{Concurrent, Resource}
import cats.implicits._
import com.quiz.typelevelstarter.http.routes.HelloWorldRoutes
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.{OptionalValidatingQueryParamDecoderMatcher, QueryParamDecoderMatcher}
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Router
import org.typelevel.log4cats.Logger

class HttpApi[F[_] : Concurrent: Logger] private(algebras: Algebras[F]) {
  private val helloWorldRoutes = HelloWorldRoutes[F](algebras.helloWorldAlg).routes

  val endpoints: HttpRoutes[F] = Router(
    "/api" -> helloWorldRoutes
  )
}

object HttpApi {
  def apply[F[_] : Concurrent: Logger](algebras: Algebras[F]): Resource[F, HttpApi[F]] = Resource.pure(new HttpApi[F](algebras))
}