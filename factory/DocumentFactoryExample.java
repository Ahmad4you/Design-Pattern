package factory;

/**
 * 
 * @author Ahmad Alrefai
 */

// Product interface
interface Document {
	void open();

	void close();
}

// Concrete products
class PDFDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening a PDF document.");
	}

	@Override
	public void close() {
		System.out.println("Closing the PDF document.");
	}
}

class WordDocument implements Document {
	@Override
	public void open() {
		System.out.println("Opening a Word document.");
	}

	@Override
	public void close() {
		System.out.println("Closing the Word document.");
	}
}

// Factory class
class DocumentFactory {
	public static Document createDocument(String type) {
		if (type.equalsIgnoreCase("pdf")) {
			return new PDFDocument();
		} else if (type.equalsIgnoreCase("word")) {
			return new WordDocument();
		} else {
			throw new IllegalArgumentException("Invalid document type.");
		}
	}

	public class DocumentFactoryExample {

		public static void main(String[] args) {
			Document pdfDocument = DocumentFactory.createDocument("pdf");
			pdfDocument.open();
			pdfDocument.close();

			Document wordDocument = DocumentFactory.createDocument("word");
			wordDocument.open();
			wordDocument.close();
		}
	}
}
