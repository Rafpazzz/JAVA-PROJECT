package Cadastro;

import java.util.Scanner;

public class Pedido {
    private String nome_Atendente;
    private String cpf_Cliente;
    private double valor_Final = 0;
    private Produto[] produtos;
    private String forma_Pagamento;
    Scanner read = new Scanner(System.in);

    public void addPedido() {
        System.out.println("Nome Atendente: ");
        nome_Atendente = read.nextLine();
        System.out.println("Cpf Cliente: ");
        cpf_Cliente = read.nextLine();
        System.out.println("Forma de pagamento: ");
        forma_Pagamento = read.nextLine();

    }

    public String getNome_Atendente() {
        return nome_Atendente;
    }

    public void setNome_Atendente(String nome_Atendente) {
        this.nome_Atendente = nome_Atendente;
    }

    public String getCpf_Cliente() {
        return cpf_Cliente;
    }

    public void setCpf_Cliente(String cpf_Cliente) {
        this.cpf_Cliente = cpf_Cliente;
    }

    public double getValor_Final() {
        return valor_Final;
    }

    public void setValor_Final(Produto[] produto) {
        for(Produto prod : produto) {
            valor_Final += prod.getValor();
        }

    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public String getForma_Pagamento() {
        return forma_Pagamento;
    }

    public void setForma_Pagamento(String forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }
}
