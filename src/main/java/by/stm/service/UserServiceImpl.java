package by.stm.service;

import by.stm.domain.User;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class UserServiceImpl implements UserService {

    //--Константы ошибок
    private final String ERR_USER_NOT_FOUND = "Пользователь с таким номером не найден";

    private List<User> userList = new ArrayList<>();
    private String lastError = "";

    //--Валидация email
    private boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            //--Пробуем отправить письмо
            try {
                Properties props = new Properties();
                props.put("mail.transport.protocol", "smtps");
                props.put("mail.smtps.host", "smtp.mail.ru");
                props.put("mail.smtps.auth", "true");
                props.put("mail.smtp.sendpartial", "true");
                Session session = Session.getDefaultInstance(props);
                //создаем сообщение
                MimeMessage message = new MimeMessage(session);

                //Указываем, от кого
                message.setFrom("bsuir_teletrade@bk.ru");

                //устанавливаем тему письма
                message.setSubject("тестовое письмо!");

                //добавляем текст письма
                message.setText("Asta la vista, baby!");

                //указываем получателя
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("stm_tmp@bk.ru"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("stm.tmp@gmail.com"));
                //message.setRecipient(Message.RecipientType.TO, new InternetAddress("stm_tmp@bk.ru"));

                //указываем дату отправления
                message.setSentDate(new Date());

                //логин и пароль gmail пользователя
                String userLogin = "bsuir_teletrade@bk.ru";
                String userPassword = "Nyashka666";

                //авторизуемся на сервере:
                Transport transport = session.getTransport();
                transport.connect("smtp.mail.ru", 465, userLogin, userPassword);

                //отправляем сообщение:
                transport.sendMessage(message, message.getAllRecipients());
            }
            catch (MessagingException e) {
                    e.printStackTrace();
                }

        } catch (AddressException ex) {
                result = false;
            }
            return result;
        }

    @Override
    public List getUserList() {
        return userList;
    }

    @Override
    public User getUserById(int idUser) {
        User result = null;
        if (idUser > 0 && idUser <= userList.size()){ result = userList.get(idUser); }
        else { lastError = ERR_USER_NOT_FOUND; }
        return result;
    }

    @Override
    public boolean addUser(User newUser) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        if (isValidEmailAddress(newUser.getEmail())) { userList.add(newUser); }
        else { result = false;}
        return result;
    }

    @Override
    public boolean editUser(int idUser, User editedUser) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        userList.add(idUser, editedUser);
        return result;
    }

    @Override
    public boolean delUser(int idUser) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        userList.remove(idUser);
        return false;
    }

    @Override
    public String getLastError() {
        return lastError;
    }
}
