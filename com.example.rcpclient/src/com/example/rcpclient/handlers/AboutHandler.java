package com.example.rcpclient.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import jakarta.xml.ws.Endpoint;

public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
		String url = "http://localhost:4434/miniwebservice";
		Endpoint.publish(url, new WebServiceExample());
	}
}
