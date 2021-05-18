package com.example.rcpclient.handlers;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import com.vogella.jaxb.model.Book;


public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
		try {
			testJaxB();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void testJaxB() throws FileNotFoundException {


		// create books
		var book1 = new Book();
		book1.setIsbn("978-0060554736");
		book1.setName("The Game");
		book1.setAuthor("Neil Strauss");
		book1.setPublisher("Harpercollins");


		// create JAXB context and instantiate marshaller
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Book.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Write to System.out
			m.marshal(book1, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
