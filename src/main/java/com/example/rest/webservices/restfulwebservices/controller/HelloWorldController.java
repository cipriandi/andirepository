package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String getHelloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean( "Hello World");
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean( String.format("Hello World, " + name));
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String getHelloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale) {

		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
