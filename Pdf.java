import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	
  private String FILE; 
  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
  private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.NORMAL);
  private static int number=0;

  public void createPDF(Integer clientID, String name, String phone, String address, String email, Integer credit,Integer 
		  bookID,String title, String authorsFN, String authorsLN, String publisher, String categories, Integer price) {
	  FILE="C:/Users/Paul/Desktop/Receipt "+clientID+" "+bookID+" "+number+" .pdf";
	  try {
    	number++;
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addPage(document, clientID, name,  phone,  address,  email,  credit, 
    		  bookID, title,  authorsFN,  authorsLN,  publisher,  categories,  price);
      document.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private static void addPage(Document document, Integer clientID, String name, String phone, String address, String email, Integer credit, Integer bookID, String title, String authorsFN, String authorsLN, String publisher, String categories, Integer price)
      throws DocumentException {
    Paragraph paragraph = new Paragraph();
  
    addEmptyLine(paragraph, 1);

    paragraph.add(new Paragraph("Receipt number: "+(number-1), catFont));
    addEmptyLine(paragraph, 1);

    paragraph.add(new Paragraph("Recepit generated on: "+ new Date(), small));
    addEmptyLine(paragraph, 3);
    paragraph.add(new Paragraph("This document is here to certified that on "+ new Date()+ " the client identified with the folowings: "
    		+ " Client ID: "+clientID+", Name: "+name+", Phone: "+phone+", Address: "+address+", Email: "+email+" has bought the folowing book form our store: "
    				+ " ID: "+bookID+", Title: "+title+", Authors's FirstNames: "+authorsFN+", Authors's LastNames: "+authorsLN+", Publisher: "+publisher+
    						 ", Categories: "+categories+" and paid the price of "+price+" so that his/hers new credit is now of "+credit+".",small));
    addEmptyLine(paragraph, 8);

    document.add(paragraph);
  }

  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }


public void open(Integer clientID, Integer bookID) {
	if (Desktop.isDesktopSupported()) {
	    try {
	        File myFile = new File("C:/Users/Paul/Desktop/Receipt "+clientID+" "+bookID+" "+(number-1)+" .pdf");
	        Desktop.getDesktop().open(myFile);
	    } catch (IOException ex) {
	        // no application registered for PDFs
	    }
	}
	
}
} 