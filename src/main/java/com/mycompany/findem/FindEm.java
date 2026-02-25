package com.mycompany.findem;

import com.mycompany.findem.controller.AnimalController;
import com.mycompany.findem.model.FormLogin;
import com.mycompany.findem.model.User;
import com.mycompany.findem.model.CategoriaAnuncio;
import com.mycompany.findem.model.Especie;
import com.mycompany.findem.repository.AnimalRepository;
import com.mycompany.findem.repository.UserRepository;
import com.mycompany.findem.service.AnimalService;
import com.mycompany.findem.service.LoginService;
import com.mycompany.findem.service.CadastroService;
import com.mycompany.findem.model.FormCadastro;
import java.util.Scanner;

public class FindEm {

    public static void main(String[] args) {

        AnimalRepository repository = new AnimalRepository();
        AnimalService service = new AnimalService(repository);
        AnimalController controller = new AnimalController(service);

        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        LoginService loginService = new LoginService(userRepository);
        CadastroService cadastroService = new CadastroService(userRepository);
        User user1 = null;

        int option = -1;

        while (option != 0) {

            System.out.println("Bem Vindo ao FindEm!!");
            System.out.println("Navegue pelas funcionalidades do sistema\n");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Fazer Cadastro");
            System.out.println("3 - Favoritar animal");
            System.out.println("4 - Entrar em contato");
            System.out.println("5 - Fazer publicação");
            System.out.println("6 - Logout");
            System.out.println("0 - Sair do programa\n");

            option = scanner.nextInt();

            switch (option) {

                case 1:
                    scanner.nextLine();

                    FormLogin formLogin = new FormLogin();

                    System.out.print("Email: ");
                    formLogin.setEmail(scanner.nextLine());

                    System.out.print("Senha: ");
                    formLogin.setPassword(scanner.nextLine());

                    User usuarioLogado = loginService.login(formLogin);

                    if (usuarioLogado != null) {
                        user1 = usuarioLogado;
                        System.out.println("Login realizado com sucesso");
                    } else {
                        System.out.println("Email ou senha inválidos");
                    }
                    break;

                case 2:
                    scanner.nextLine();

                    FormCadastro formCadastro = new FormCadastro();

                    System.out.print("Nome: ");
                    formCadastro.setNome(scanner.nextLine());

                    System.out.print("Email: ");
                    formCadastro.setEmail(scanner.nextLine());

                    System.out.print("Senha: ");
                    formCadastro.setPassword(scanner.nextLine());

                    System.out.print("Confirme sua Senha: ");
                    formCadastro.setConfirmarSenha(scanner.nextLine());

                    System.out.print("Contato: ");
                    formCadastro.setContato(scanner.nextLine());

                    String resultadoCadastro = cadastroService.cadastrar(formCadastro);
                    System.out.println(resultadoCadastro);
                    break;

                case 3:
                    if (user1 == null || !user1.isLogado()) {
                        System.out.println("Você precisa estar logado para favoritar um animal");
                        break;
                    }

                    System.out.println(controller.listaDeAnimais());
                    System.out.println("Digite o ID do animal que deseja favoritar: ");
                    int idFavoritar = scanner.nextInt();

                    String resultado = controller.favoritar(idFavoritar, user1);
                    System.out.println(resultado);
                    break;

                case 4:
                    if (user1 == null || !user1.isLogado()) {
                        System.out.println("Você precisa estar logado para entrar em contato com o dono");
                        break;
                    }

                    System.out.println(controller.listaDeAnimais());
                    System.out.print("Digite o ID do animal para ver o contato: ");
                    int idContato = scanner.nextInt();

                    System.out.println(controller.pegarContato(idContato, user1));
                    break;

               case 5:
                    if (user1 == null || !user1.isLogado()) {
                        System.out.println("Você precisa estar logado para realizar uma postagem");
                        break;
                    }

                    scanner.nextLine();

                    System.out.println("--- NOVO CADASTRO ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();

                    System.out.print("Espécie (CACHORRO, GATO, OUTRO): ");
                    String especieStr = scanner.nextLine().toUpperCase();
                    Especie especieEnum = null;
                    try {
                        especieEnum = Especie.valueOf(especieStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Espécie inválida! Postagem cancelada.");
                        break;
                    }

                    System.out.print("Categoria (PERDIDO, ENCONTRADO, ADOCAO): ");
                    String categoriaStr = scanner.nextLine().toUpperCase();
                    CategoriaAnuncio categoriaEnum = null;
                    try {
                        categoriaEnum = CategoriaAnuncio.valueOf(categoriaStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: Categoria inválida! Postagem cancelada.");
                        break;
                    }

                    System.out.print("Estado (UF): ");
                    String estado = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Último local visto: ");
                    String local = scanner.nextLine();

                    String msgCadastro = controller.recebeForm(
                            nome, raca, especieEnum, categoriaEnum,
                            estado, cidade, local, user1
                    );

                    System.out.println(msgCadastro);
                    break;
                    
                    case 6:
                    if (user1 != null && user1.isLogado()) {
                        loginService.logout(user1);
                        user1 = null;
                        System.out.println("Logout realizado com sucesso");
                    } else {
                        System.out.println("Nenhum usuário está logado");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}