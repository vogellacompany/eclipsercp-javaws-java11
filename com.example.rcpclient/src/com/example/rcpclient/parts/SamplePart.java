package com.example.rcpclient.parts;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.widgets.LabelFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.example.rcpclient.webservice.WebServiceExample;

public class SamplePart {

	@Inject
	private MPart part;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		// starting a webservice
		System.setProperty("jakarta.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
		System.setProperty("javax.xml.soap.SAAJMetaFactory", "com.sun.xml.messaging.saaj.soap.SAAJMetaFactoryImpl");
		String url = "http://localhost:4428/miniwebservice";

		ClassLoader tccl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		try {
			javax.xml.ws.Endpoint.publish(url, new WebServiceExample());
		} finally {
			Thread.currentThread().setContextClassLoader(tccl);
		}

		Label create = LabelFactory.newLabel(SWT.NONE).text("Running service at " + url).create(parent);
	}

}