package com.sadhen.spring.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * Created by rendong on 17/2/6.
  */
object Application extends App {
  val app = new SpringApplication(classOf[Application])
  app.run(args: _*)
}

@SpringBootApplication
class Application
