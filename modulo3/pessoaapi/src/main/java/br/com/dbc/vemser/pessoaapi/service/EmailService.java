package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("cassia.guimaraes@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Meu e-mail");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo("cassia.guimaraes@dbccompany.com.br");
        helper.setSubject("Assunto 1");
        helper.setText("Meu email!");

//        File file1 = new File("imagem.jpg");
//        FileSystemResource file = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);
        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("image.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

        emailSender.send(message);
    }

    public void sendEmailCriarPessoa(PessoaDTO pessoaDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setText(pessoaDTO.getEmail());
        message.setSubject("Bem vindo(a)!");
        message.setText("Olá " +pessoaDTO.getNome()+ ", \n" +
                "Estamos felizes em ter você em nosso sistema :) \n"+
                "Seu cadastro foi realizado com sucesso, seu identificador é " +pessoaDTO.getIdPessoa()+"\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail cassia.guimaraes@dbccompany.com.br \n"+
                "Att, Sistema");
        emailSender.send(message);
    }
    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto3");
            mimeMessageHelper.setText(getContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch  (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "MeuNome");
        dados.put("email", "aaa@aaa");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
