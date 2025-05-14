package Ambiente_Do_Usuario;

import Cadastro.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class test_Arquivos {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\Raf\\Documents\\GitHub\\JAVA-PROJECT\\Farmacia\\src\\Banco_Arquivos\\Cliente.txt");
        File file2 = new File("C:\\Users\\Raf\\Documents\\GitHub\\JAVA-PROJECT\\Farmacia\\src\\Banco_Arquivos\\Produto.txt");
        File file3 = new File("C:\\Users\\Raf\\Documents\\GitHub\\JAVA-PROJECT\\Farmacia\\src\\Banco_Arquivos\\Pedido.txt");
        int escolha;
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
                    clientes.add(c);
                    addCliente(c, file1);

                    break;

            }
        } while (escolha <= 3);

    }

    public static void addArquivo(Object a, File file) {
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter br = new BufferedWriter(fw)) {
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

    public static void addCliente(Cliente o, File file) {
        ArrayList<String> linhas = new ArrayList<String>();
        boolean encontrado = false;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    if (linha.equals(o.toString())) {
                        System.out.println("Cliente encontrado no sistema");
                        o.setFidelidade(true);
                        linhas.add(o.toString());
                        encontrado = true;
                        System.out.println("Dados atualizados");

                    } else {
                        linhas.add(linha);
                    }
                }

                if (!encontrado) {
                    linhas.add(o.toString());
                }

                try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
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
