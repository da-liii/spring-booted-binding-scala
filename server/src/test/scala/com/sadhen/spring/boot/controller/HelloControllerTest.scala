package com.sadhen.spring.boot.controller

import com.fasterxml.jackson.databind.JsonNode
import org.json4s.JsonAST.{JNull, JValue}
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.scalatest.Assertions._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

/**
  * Created by rendong on 17/3/26.
  */
@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerTest {
  @Autowired
  var restTemplate: TestRestTemplate = _

  @Test
  def testHello(): Unit = {
    val body = restTemplate.getForObject("/api/hello", classOf[JsonNode])
    val expected = ("code" -> 0) ~
      ("data" -> ("hello" -> "中国") ~ ("year" -> 2017)) ~
      ("error" -> JNull)
    assert {
      fromJsonNode(body) == expected
    }
  }
}
