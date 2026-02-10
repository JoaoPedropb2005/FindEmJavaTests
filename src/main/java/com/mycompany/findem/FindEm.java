/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.findem;

import com.mycompany.findem.controller.AnimalController;
import com.mycompany.findem.model.User;
import com.mycompany.findem.repository.AnimalRepository;
import com.mycompany.findem.service.AnimalService;
import java.util.Scanner;

/**
 *
 * @author jppb2
 */
public class FindEm {

    public static void main(String[] args) {

        AnimalRepository repository = new AnimalRepository();
        AnimalService service = new AnimalService(repository);
        AnimalController controller = new AnimalController(service);

        Scanner scanner = new Scanner(System.in);
        User user1 = new User();

        user1.setNome("Pedro");
        user1.setContato("9999-9999");

        int option = -1;

        while (option != 0) {

            System.out.println("Bem Vindo ao FindEm!!");
            System.out.println("Navegue pelas funcionalidades do sistema\n");
            System.out.println("1 - Fazer login");
            System.out.println("2 - Favoritar animal");
            System.out.println("3 - Entrar em contato");
            System.out.println("4 - Fazer publicação");
            System.out.println("0 - Sair do programa\n");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    user1.setIsLogado(true);
                    break;
                case 2:
                    if (!user1.getIsLogado()) {
                        System.out.println("Você precisa estar logado para favoritar um animal");
                        break;
                    } else {
                        System.out.println(controller.listaDeAnimais());

                        System.out.println("Digite o ID do animal que deseja favoritar: ");
                        int idFavoritar = scanner.nextInt();

                        String resultado = controller.favoritar(idFavoritar, user1);
                        System.out.println(resultado);
                    }
                    break;
                case 3:
                    if (!user1.getIsLogado()) {
                        System.out.println("Você precisa estar logado para entrar em contato com o dono");
                        break;
                    }

                    System.out.println(controller.listaDeAnimais());

                    System.out.print("Digite o ID do animal para ver o contato: ");
                    int idContato = scanner.nextInt();

                    System.out.println(controller.pegarContato(idContato));

                    break;
                case 4:
                    if (!user1.getIsLogado()) {
                        System.out.println("Você precisa estar logado para realizar uma postagem");
                        break;
                    }
                    scanner.nextLine();

                    System.out.println("--- NOVO CADASTRO ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();

                    System.out.print("Espécie: ");
                    String especie = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Estado (UF): ");
                    String estado = scanner.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = scanner.nextLine();

                    System.out.print("Último local visto: ");
                    String local = scanner.nextLine();

                    String msgCadastro = controller.recebeForm(nome, raca, especie, categoria, estado, cidade, local, user1);
                    break;

                default:
                    break;
            }

        }

    }
}
