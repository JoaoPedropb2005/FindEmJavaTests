package com.mycompany.findem.repository;

import com.mycompany.findem.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julia
 */
public class UserRepository {

    private List<User> usuarios = new ArrayList<>();

    public void salvar(User user) {
        usuarios.add(user);
    }

    public User buscarPorEmail(String email) {
        for (User u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
}