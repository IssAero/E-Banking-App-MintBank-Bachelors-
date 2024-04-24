package com.licentaebank.mailMessenger;

import com.licentaebank.config.MailConfig;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailMessenger {

    public static void htmlEmailMessenger(String from, String to, String subject, String body) throws MessagingException {
        // Get Mail Config:
        JavaMailSender sender = MailConfig.getMailConfig();
        // Set Mime Message:
        MimeMessage message = sender.createMimeMessage();
        // Set Mime Message Helper:
        MimeMessageHelper htmlMessage = new MimeMessageHelper(message, true);

        // Set Mail Attributes / Properties:
        htmlMessage.setTo(to);
        htmlMessage.setFrom(from);
        htmlMessage.setSubject(subject);
        htmlMessage.setText(body, true);
        // Send Message:
        sender.send(message);

    }
    // End of HTML email message method.

}
