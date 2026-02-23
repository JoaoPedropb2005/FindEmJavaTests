package com.mycompany.findem.service;

import com.mycompany.findem.model.FormLogin;
import com.mycompany.findem.model.User;
import com.mycompany.findem.repository.UserRepository;

/**
 *
 * @author Julia
 */
public class LoginService {

    private UserRepository repository;

    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    public User login(FormLogin form) {

        if (form.getEmail() == null || form.getEmail().isEmpty())
            return null;

        if (!form.getEmail().endsWith("@gmail.com"))
            return null;

        if (form.getPassword() == null || form.getPassword().isEmpty())
            return null;

        User user = repository.buscarPorEmail(form.getEmail());

        if (user == null)
            return null;

        if (!user.getPassword().equals(form.getPassword()))
            return null;

        user.setLogado(true);

        return user;
    }

    public void logout(User user) {
        if (user != null) {
            user.setLogado(false);
        }
    }
}