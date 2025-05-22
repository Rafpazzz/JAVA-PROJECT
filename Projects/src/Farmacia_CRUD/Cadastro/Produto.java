package Farmacia_CRUD.Cadastro;

import java.util.Scanner;

public class Produto {
    private String nome_Produto;
    private String composicao;
    private String tipo_Produto;
    private String fabricante;
    private String tarja;
    private String validade;
    private boolean needReceita;
    private int quantidade_Produto;
    private int codigo;
    private double dosagem;
    private double valor;
    Scanner read = new Scanner(System.in);


    public void addProduto() {
        System.out.println("Nome do produto: ");
        nome_Produto = read.nextLine();
        System.out.println("Composição do Produto: ");
        composicao = read.nextLine();
        System.out.println("Tipo de produto comprado[remedio/limpeza pessoal/alimenticio]: ");
        tipo_Produto = read.nextLine();
        System.out.println("Fabricante: ");
        fabricante = read.nextLine();
        System.out.println("Tarja: ");
        tarja = read.nextLine();
        System.out.println("Validade: ");
        validade = read.nextLine();
        System.out.println("Precisa de receita[sim/nao]: ");
        String a = read.nextLine();
        if(a.equals("sim")){
            needReceita = true;
        } else if (a.equals("nao")) {
            needReceita = false;
        }else{
            needReceita = false;
        }
        System.out.println("Quantidade em estoque: ");
        quantidade_Produto = read.nextInt();
        System.out.println("Codigo preoduto: ");
        codigo = read.nextInt();
        System.out.println("Dosagem(mg): ");
        dosagem = read.nextDouble();
        System.out.println("Valor do produto(uni): ");
        valor = read.nextDouble();
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getTipo_Produto() {
        return tipo_Produto;
    }

    public void setTipo_Produto(String tipo_Produto) {
        this.tipo_Produto = tipo_Produto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public boolean isNeedReceita() {
        return needReceita;
    }

    public void setNeedReceita(boolean needReceita) {
        this.needReceita = needReceita;
    }

    public int getQuantidade_Produto() {
        return quantidade_Produto;
    }

    public void setQuantidade_Produto(int quantidade_Produto) {
        this.quantidade_Produto = quantidade_Produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produto{");
        sb.append("nome_Produto='").append(nome_Produto).append('\'');
        sb.append(", composicao='").append(composicao).append('\'');
        sb.append(", tipo_Produto='").append(tipo_Produto).append('\'');
        sb.append(", fabricante='").append(fabricante).append('\'');
        sb.append(", tarja='").append(tarja).append('\'');
        sb.append(", validade='").append(validade).append('\'');
        sb.append(", needReceita=").append(needReceita);
        sb.append(", quantidade_Produto=").append(quantidade_Produto);
        sb.append(", codigo=").append(codigo);
        sb.append(", dosagem=").append(dosagem);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
