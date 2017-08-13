package com.sadhen.spring.boot.configure

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.{EnableWebMvc, WebMvcConfigurerAdapter}
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import java.util.{ List => JList }

@Configuration
@EnableWebMvc
class WebConfig extends WebMvcConfigurerAdapter {
  override def configureMessageConverters(converters: JList[HttpMessageConverter[_]]): Unit =
    converters.add(jackson2HttpMessageConverter())

  @Bean
  def jackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter =
    new MappingJackson2HttpMessageConverter(objectMapper())

  override def addResourceHandlers(registry: ResourceHandlerRegistry): Unit = {
    if (!registry.hasMappingForPattern("/webjars/**"))
      registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/")
  }

  @Bean
  def objectMapper() =
    new ObjectMapper() {
      setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
      registerModule(DefaultScalaModule)
    }
}

