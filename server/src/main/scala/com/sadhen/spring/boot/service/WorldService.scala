package com.sadhen.spring.boot.service

import org.springframework.stereotype.Service

/**
  * Created by rendong on 17/3/26.
  */
@Service
class WorldService {
  def getCountry: String = {
    "中国"
  }
}
