package Ambiente_Do_Usuario;

import Cadastro.Cliente;
import Cadastro.Pedido;
import Cadastro.Produto;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class test_Arquivos {
    public static void main(String[] args) {
        Path path1 = Paths.get("Cliente.txt");
        Path path2 = Paths.get("Produto.txt");
        Path path3 = Paths.get("Pedido.txt");
        int escolha, getI = -1;
        boolean encontrado = false;
        Scanner r = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        do {
            System.out.println("SISTEMA DE CADASTRO DE FARMÁCIA");
            System.out.println("[1].Cadastrar Cliente");
            System.out.println("[2].Cadastrar Produto");
            System.out.println("[3].Cadastrar Pedido");
            System.out.print("Escolha uma das opções acima: ");
            escolha = r.nextInt();

            switch (escolha) {
                case 1:
                    Cliente c = new Cliente();
                    c.addCliente();
                    addCliente(c,path1);
                    for(int i = 0; i<clientes.size(); i++) {
                        if(c.equals(clientes.get(i))) {
                            getI = i;
                        }
                    }
                    clientes.remove(getI);
                    clientes.add(c);
                    break;
                case 2:
                    Produto p = new Produto();
                    p.addProduto();
                    addArquivo(p,path2);
                    break;
                case 3:
                    Pedido ped = new Pedido();
                    ped.addPedido();
                    addArquivo(ped,path3);
                    break;
            }
        } while (escolha <= 3);

    }

    public static void addArquivo(Object a, Path file) {
        try (FileWriter fw = new FileWriter(file.toFile(), true); BufferedWriter br = new BufferedWriter(fw)) {
            br.write(a.toString());
            br.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readArquivo(File file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCliente(Cliente o, Path path) {
        ArrayList<String> linhas = new ArrayList<String>();
        boolean dentroArray = false;
        try {
            try (FileReader fr = new FileReader(path.toFile()); BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    if (linha.equals(o.toString())) {
                        System.out.println("Cliente encontrado no sistema");
                        o.setFidelidade(true);
                        linhas.add(o.toString());
                        dentroArray = true;
                        System.out.println("Dados atualizados");
                    } else {
                        linhas.add(linha);
                    }
                }

                if (!dentroArray) {
                    linhas.add(o.toString());
                }

                try (FileWriter fw = new FileWriter(path.toFile()); BufferedWriter bw = new BufferedWriter(fw)) {
                    for (String escrever : linhas) {
                        bw.write(escrever);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
