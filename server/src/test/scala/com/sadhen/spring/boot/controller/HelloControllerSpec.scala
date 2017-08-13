package com.sadhen.spring.boot.controller

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}
import com.sadhen.spring.boot.service.WorldService
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonAST._
import org.json4s.JsonDSL._

/**
  * Created by rendong on 17/3/26.
  */
class HelloControllerSpec extends FlatSpec with Matchers with MockFactory {

  "/api/hello" should "be ok" in {
    val worldService = stub[WorldService]
    (worldService.getCountry _).when().returns("法国")

    val helloController = new HelloController(worldService)

    val expected = ("code" -> 0) ~
      ("data" -> ("hello" -> "法国") ~ ("year" -> 2017)) ~
      ("error" -> JNull)

    assert {
      fromJsonNode(helloController.hello) == expected
    }
  }
}
