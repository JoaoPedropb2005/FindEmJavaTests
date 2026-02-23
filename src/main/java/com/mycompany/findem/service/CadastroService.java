package com.mycompany.findem.service;

import com.mycompany.findem.model.FormCadastro;
import com.mycompany.findem.model.User;
import com.mycompany.findem.repository.UserRepository;

/**
 *
 * @author Julia
 */
public class CadastroService {

    private UserRepository repository;

    public CadastroService(UserRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(FormCadastro form) {

        if (form.getNome() == null || form.getNome().isEmpty())
            return "Nome é obrigatório";

        if (form.getEmail() == null || form.getEmail().isEmpty())
            return "Email é obrigatório";

        if (!form.getEmail().endsWith("@gmail.com"))
            return "Email inválido";

        if (repository.buscarPorEmail(form.getEmail()) != null)
            return "Email já cadastrado";

        if (form.getPassword() == null || form.getPassword().isEmpty())
            return "Senha é obrigatória";

        if (form.getConfirmarSenha() == null || form.getConfirmarSenha().isEmpty())
            return "Confirmar Senha é obrigatório";

        if (form.getPassword().length() < 6)
            return "Senha deve ter no mínimo 6 caracteres";

        if (!form.getPassword().equals(form.getConfirmarSenha()))
            return "As senhas não coincidem";

        if (form.getContato() == null || form.getContato().isEmpty())
            return "Contato é obrigatório";

        User user = new User();
        user.setNome(form.getNome());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setContato(form.getContato());

        repository.salvar(user);

        return "Cadastro realizado com sucesso";
    }
}