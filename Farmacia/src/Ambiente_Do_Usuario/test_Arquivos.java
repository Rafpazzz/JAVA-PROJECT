package Ambiente_Do_Usuario;

import Cadastro.Cliente;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test_Arquivos {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Raf\\Documents\\GitHub\\JAVA-PROJECT\\Farmacia\\src\\Banco_Arquivos","test01.txt");
        Cliente cliente1 = new Cliente();
        cliente1.addCliente();
        addArquivo(cliente1, path);
        readArquivo(path);

    }

    public static void addArquivo(Cliente a, Path file) {
        try(FileWriter fw = new FileWriter(file.toFile(),true); BufferedWriter br = new BufferedWriter(fw)) {
            br.write(a.toString());
            br.newLine();
            br.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void readArquivo(Path file) {
        try(FileReader fr = new FileReader(file.toFile()); BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
