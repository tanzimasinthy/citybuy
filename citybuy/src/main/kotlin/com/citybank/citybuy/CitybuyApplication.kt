package com.citybank.citybuy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.filter.CommonsRequestLoggingFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Controller
@SpringBootApplication
class CitybuyApplication: SpringBootServletInitializer(){

	@Autowired
	@RequestMapping("/")
	@ResponseBody
	fun test(): String
	{
		return "test"
	}
}

fun main(args: Array<String>) {
	runApplication<CitybuyApplication>(*args)
}

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
	}
}

@Bean
fun requestLoggingFilter(): CommonsRequestLoggingFilter{
	val loggingFilter = CommonsRequestLoggingFilter()
	loggingFilter.setIncludeClientInfo(true)
	loggingFilter.setIncludeQueryString(true)
	loggingFilter.setIncludePayload(true)
	return loggingFilter
}

@EnableJpaRepositories
class Config {

}