package com.quiz.typelevelstarter.modules

import cats.effect.{Async, Resource}
import com.quiz.typelevelstarter.algebras.HelloWorldAlg

final class Algebras[F[_]] private (val helloWorldAlg: HelloWorldAlg[F])

object Algebras {
  def apply[F[_]: Async]: Resource[F, Algebras[F]] =
    Resource.pure(new Algebras[F](HelloWorldAlg.impl[F]))
}
