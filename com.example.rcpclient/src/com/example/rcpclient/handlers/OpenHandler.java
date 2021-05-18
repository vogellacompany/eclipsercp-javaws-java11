package com.example.rcpclient.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

import com.example.rcpclient.webservice.WebServiceExample;

public class OpenHandler {

	@Execute
	public void execute() {
		// starting a webservice
		System.setProperty("jakarta.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
		System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
		String url = "http://localhost:4437/miniwebservice";

		ClassLoader tccl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		try {
			javax.xml.ws.Endpoint.publish(url, new WebServiceExample());
		} finally {
			Thread.currentThread().setContextClassLoader(tccl);
		}

	}
}
