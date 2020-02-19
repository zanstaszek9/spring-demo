package stanislaw.appdemo.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImpl implements EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String content) {
        MimeMessage mail = null;

        try{
            mail = prepareEmail(to, subject,  content);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }


    private MimeMessage prepareEmail(String to, String subject, String content) throws MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mail, true);
        messageHelper.setTo(to);
        messageHelper.setFrom("noreply@appdemo.net");
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        return mail;
    }
}
