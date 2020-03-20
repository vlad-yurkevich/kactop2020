package by.stm.service;

import by.stm.domain.User;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

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
