/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rzsupermarket.Domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author Raf
 */
@Entity
@Table (name = "Funcionario")
public class Funcionario {
    
    @Id
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CPF")
    private char[] cpf = new char[15];
    @Column(name = "setor")
    private String setor;
    @Column (name= "Salario")
    private double salario;
    @Column(name = "Sexo")
    private char sexo;
    @Column(name = "Idade")
    private int idade;
    @Column (name = "dataNas")
    private LocalDate dataNas;

    public Funcionario(String nome, char[] cpf, String setor, double salario, char sexo, int idade, LocalDate dataNas) {
        this.nome = nome;
        this.cpf = cpf;
        this.setor = setor;
        this.salario = salario;
        this.sexo = sexo;
        this.idade = idade;
        this.dataNas = dataNas;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Arrays.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        return Arrays.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome);
        sb.append("CPF: ").append(cpf);
        sb.append("Setor: ").append(setor);
        sb.append("Salario: ").append(salario);
        sb.append("Sexo: ").append(sexo);
        sb.append("Idade: ").append(idade);
        sb.append("Data de Nascimento: ").append(dataNas);
        
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char[] getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setCpf(char[] cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNas() {
        return dataNas;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDataNas(LocalDate dataNas) {
        this.dataNas = dataNas;
    }
    
    
    
}
