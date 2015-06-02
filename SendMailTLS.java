import java.util.Date;
import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTLS {
 
	public void send(Integer clientID, String name, String phone,
			String address, String email, Integer credit, Integer bookID,
			String title, String authorsFN, String authorsLN, String publisher,
			String categories, Integer price) {
 
		final String username = "therobinhood061@gmail.com";
		final String password = "1rO2rm3rn4ri5ru6rs7rO8rn9r1re5r1";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password.replaceAll(".r", ""));
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Thank you for you purcahse!");
			message.setText("This is a confirmation email of your transaction, here is the log: On "+ new Date()+ " the client identified with the folowings: "
    		+ " Client ID: "+clientID+", Name: "+name+", Phone: "+phone+", Address: "+address+", Email: "+email+" has bought the folowing book form our store: "
    				+ " ID: "+bookID+", Title: "+title+", Authors's FirstNames: "+authorsFN+", Authors's LastNames: "+authorsLN+", Publisher: "+publisher+
    						 ", Categories: "+categories+" and paid the price of "+price+" so that his/hers new credit is now of "+credit+".");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}