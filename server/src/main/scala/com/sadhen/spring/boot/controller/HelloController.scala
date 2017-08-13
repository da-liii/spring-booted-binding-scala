package com.sadhen.spring.boot.controller

import com.fasterxml.jackson.databind.JsonNode
import com.sadhen.spring.boot.service.WorldService
import org.json4s.JsonAST.{JInt, JString, JValue}
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

/**
  * Created by rendong on 17/3/24.
  */
@RestController
@RequestMapping(value = Array("/api"))
class HelloController @Autowired() (worldService: WorldService) {
  implicit def autoAsJsonNode(value: JValue): JsonNode = asJsonNode(value)

  @RequestMapping(value = Array("/hello"))
  def hello: JsonNode = {
    val world: String = worldService.getCountry

    ("code" -> 0) ~
      ("data" -> ("hello" -> world) ~ ("year" -> 2017)) ~
      ("error" -> null)
  }

  @RequestMapping(value = Array("/echo"), method = Array(RequestMethod.POST))
  def echo(@RequestBody body: JsonNode): JsonNode = {
    val json = fromJsonNode(body)
    (json \ "hello", json \ "year") match {
      case (JString(world), JInt(year)) =>
        ("code" -> 0) ~
          ("data" -> ("hello" -> world) ~ ("year" -> year)) ~
          ("error" -> null)
      case _ =>
        ("code" -> 1) ~
          ("data" -> null) ~
          ("error" -> "invalid post body")
    }
  }
}
