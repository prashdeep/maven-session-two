package com.classpath.ftp27.util;

import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.DefaultAuthenticator;
import java.util.Map;
/**
* Emailutil class.
*/
public final class EmailUtil {
  private EmailUtil() {
  }
/**
* Utility method to send simple email.
* @param toEmail to get recipent mail id.
* @param subject to get subject of the mail.
* @param body to get body of mail.
*/
  public static void sendEmailForApply(final String toEmail, final String subject, final String body) {
    try {
      Email email = new SimpleEmail();
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      Map<String, String> pass = System.getenv();
      String password = pass.get("PASSWORD_HOME");
      if (password != null) {
        email.setAuthenticator(new DefaultAuthenticator("ftphexaware@gmail.com", password));
        email.setSSLOnConnect(true);
        email.setFrom("ftphexaware@gmail.com");
        email.setSubject(subject);
        email.setMsg(body);
        email.addTo(toEmail);
        email.send();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
/**
* Utility method to send simple email.
* @param toEmail to get recipent mail id.
* @param leaveId to get subject of the mail.
* @param mgrComment to get body of mail.
* @param status to get body of mail.
*/
  public static void sendEmailForApprove(final int leaveId, final String mgrComment, final String status,
      final String toEmail) {
    try {
      Email email = new SimpleEmail();
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      Map<String, String> pass = System.getenv();
      String password = pass.get("PASSWORD_HOME");
      if (password != null) {
        email.setAuthenticator(new DefaultAuthenticator("ftphexaware@gmail.com", password));
        email.setSSLOnConnect(true);
        email.setFrom("ftphexaware@gmail.com");
        String subject = "Your leave request [leave Id : " + leaveId + "]got" + status;
        String body = "Your leave request [leave Id : " + leaveId + "]got" + status
            + ".\nManager Comment is " + mgrComment;
        email.setSubject(subject);
        email.setMsg(body);
        email.addTo(toEmail);
        email.send();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
