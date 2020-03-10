package by.stm.service;

import by.stm.domain.User;

import java.util.List;

public interface UserService {
    List getUserList();
    User getUserById(int idUser);
    boolean addUser(User newUser);
    boolean editUser(int idUser, User editedUser);
    boolean delUser(int idUser);
    String getLastError();
}
