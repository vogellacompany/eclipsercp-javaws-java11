package com.example.maven;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

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
		String url = "http://localhost:4434/miniwebservice";
		Endpoint.publish(url, new WebServiceExample());
	}
}