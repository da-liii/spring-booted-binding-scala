package com.sadhen.spring.boot.scheduler

import java.time.LocalDate

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.log4s._

/**
  * Created by rendong on 17/2/19.
  */
@Component
class HeartBeat {
  private[this] val log = getLogger

  @Scheduled(fixedDelay = 10000, initialDelay = 1000)
  def beat(): Unit = {
    log.info(s"heart beat at ${LocalDate.now.toString}")
    log.debug("I'm debugging")
  }
}
