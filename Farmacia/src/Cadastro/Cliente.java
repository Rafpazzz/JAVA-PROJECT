package Cadastro;

import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private boolean isFidelidade;
    Scanner read = new Scanner(System.in);

    public void addCliente() {
        System.out.print("Infrome o nome: ");
        nome = read.nextLine();
        System.out.print("Informe o CPF: ");
        cpf = read.nextLine();
        System.out.println("Informe o Endereço: ");
        endereco = read.nextLine();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
