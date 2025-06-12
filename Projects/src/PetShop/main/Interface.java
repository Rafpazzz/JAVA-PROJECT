package PetShop.main;

//import PetShop.BancoDados.View;
import PetShop.Implementacoes.AnimalDAO;
import PetShop.Objetos.Animal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        List<Animal> listAnimal = new ArrayList<>();
        Animal animal;
        AnimalDAO ani = new AnimalDAO();
        Scanner s = new Scanner(System.in);
       // View visao = new View();
        int opcao;
        File file = new File("BancoArquivo.csv");
        //visao.lerValoresBanco(visao.conectar(), listAnimal);

        do{
            System.out.println("=== Sistema de Cadastro de Pets ===");
            System.out.println("[1].Adicionar Pet");
            System.out.println("[2].Remover Pet");
            System.out.println("[3].Buscar Pet");
            System.out.println("[4].Mostrar Lista de Pet");
            System.out.println("[5].Sair do Menu");
            System.out.print("Escolha sua opção: ");
            opcao = s.nextInt();
            s.nextLine();

            switch(opcao) {
                case 1:
                    System.out.println("Preencha os campos abaixo:");
                    System.out.print("Nome: ");
                    String nome = s.nextLine();
                    System.out.print("Tipo[C = cachorro; G = Gato]: ");
                    String tipo = s.nextLine().toUpperCase();
                    System.out.println("Raça: ");
                    String raca = s.nextLine();
                    animal = new Animal(nome, tipo, raca);
                    ani.adicionar(animal,listAnimal, file);
                    break;

                case 2:
                    System.out.print("Insira um Id valido: ");
                    Long idRemover = s.nextLong();
                    ani.remover(idRemover, listAnimal, file);
                    break;

                case 3:
                    System.out.print("Insira um Id valido: ");
                    Long idBusca = s.nextLong();
                    ani.buscarAnima(idBusca, listAnimal);
                    break;

                case 4:
                    System.out.println(listAnimal.toString());
                    break;

                case 5:
                    System.out.println("See you Later");
                    break;

                default:
                    System.out.println("Opção invalida. Escolha dentre 1 a 4");
            }


        }while(opcao != 5);
    }
}
