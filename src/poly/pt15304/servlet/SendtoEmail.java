package poly.pt15304.servlet;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SendtoEmail
 */
@WebServlet("/Send")
public class SendtoEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendtoEmail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/view/paragr/SendEmail.jsp";
		request.setAttribute("view", view);
		request.getRequestDispatcher("/view/layout.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username  = "viphn04@gmail.com";
		String password  = "01682235070";
		
		Properties prop =new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Session session =Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		String Email1  = req.getParameter("email");
		String EmailSubject  = req.getParameter("Subject");
		String EmailContent  = req.getParameter("Content");
	
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email1));
			message.setSubject(EmailSubject);
			message.setText(EmailContent);
			message.setReplyTo(message.getFrom());
			Transport.send(message);
			System.out.println("Thành công.");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Thành công.");
	}

}

