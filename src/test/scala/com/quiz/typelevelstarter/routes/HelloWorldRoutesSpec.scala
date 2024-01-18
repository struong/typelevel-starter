package com.quiz.typelevelstarter.routes

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import com.quiz.typelevelstarter.algebras.HelloWorldAlg
import com.quiz.typelevelstarter.http.routes.HelloWorldRoutes
import org.http4s._
import org.http4s.implicits._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class HelloWorldRoutesSpec extends AnyWordSpec with Matchers {

  val retHelloWorld: IO[Response[IO]] = {
    val getHW      = Request[IO](Method.GET, uri"/hello/world")
    val helloWorldAlg = HelloWorldAlg.impl[IO]
    HelloWorldRoutes(helloWorldAlg).routes.orNotFound(getHW)
  }

  "HelloWorldAlg" should {
    "returns status code 200" in {
      val result = retHelloWorld.unsafeRunSync()
      result.status shouldBe Status.Ok
    }
    "returns hello world message" in {
      val result = retHelloWorld.flatMap(_.as[String]).unsafeRunSync()
      result shouldBe "{\"message\":\"Hello, world\"}"
    }
  }
}
