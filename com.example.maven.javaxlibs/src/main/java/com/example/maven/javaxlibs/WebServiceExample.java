package com.example.maven.javaxlibs;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WebServiceExample {
	private String message = new String("Hello, ");

	public void Hello() {
	}

	@WebMethod
	public String sayHello(String name) {
		return message + name + ".";
	}

	public static void main(String[] args) {
		String url = "http://localhost:4435/miniwebservice";
		Endpoint.publish(url, new WebServiceExample());
	}
}