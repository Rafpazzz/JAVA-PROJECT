/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rzsupermarket.Services;

import com.mycompany.rzsupermarket.Domain.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raf
 */
public class FuncionarioDAO {

    public boolean VerioficaPreenchimento(String nome, String cpf, String setor, String dataNas) {
        if (nome == null || nome.trim().isEmpty() || cpf == null || cpf.trim().isEmpty() || setor == null || setor.trim().isEmpty() || dataNas == null || dataNas.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prencha o campo vazio");
            return false;
        }

        return true;
    }
    
    public boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Não permite datas inválidas

        try {
            sdf.parse(data);
            return true;  // Data válida
        } catch (ParseException e) {
            return false;  // Data inválida
        }
    }
    
    public int calcularIdade(LocalDate dataNas) {
        LocalDate now = LocalDate.now();
        
        int idade = Period.between(dataNas, now).getYears();
        
        return idade;
    }
    
    public void addFuncionario(List<Funcionario> listFunc, Funcionario func) {
        if(listFunc.contains(func)) {
            JOptionPane.showMessageDialog(null, "Funcionario ja Existe No sistema", "Mensagem do SIstema", JOptionPane.ERROR_MESSAGE);
        }else {
            listFunc.add(func);
            JOptionPane.showMessageDialog(null, "Funcionario adcionado no sistema");
        }
    }
    
    public void removerFunc(List<Funcionario> listFunc, String cpf) {
        Funcionario funcionarioARemover = null;
        
        for(Funcionario func : listFunc) {
            if(String.valueOf(func.getCpf()).equals(cpf)){
                funcionarioARemover = func;
                break;
            }
        }
        
        if(funcionarioARemover != null) {
            listFunc.remove(funcionarioARemover);
        }else {
            JOptionPane.showMessageDialog(null, "Funcionario não existe no sistema", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarFunc(List<Funcionario> listFunc, String cpf) {
        Funcionario funcionarioABuscar = null;
        
        for(Funcionario func : listFunc) {
            if(String.valueOf(func.getCpf()).equals(cpf)){
                funcionarioABuscar = func;
                break;
            }
        }
        
        if(funcionarioABuscar != null) {
            JOptionPane.showMessageDialog(null, "Funcionario: "+funcionarioABuscar.toString());
        }else {
            JOptionPane.showMessageDialog(null, "Funcionario não existe no sistema", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void AlterarSalario(List<Funcionario> listFunc, String cpf, double valor) {
        Funcionario funcionarioABuscar = null;
        
        for(Funcionario func : listFunc) {
            if(String.valueOf(func.getCpf()).equals(cpf)){
                funcionarioABuscar = func;
                break;
            }
        }
        
        if(funcionarioABuscar != null) {
            double salarioNovo = funcionarioABuscar.getSalario() + (funcionarioABuscar.getSalario()*valor/100);
            funcionarioABuscar.setSalario(salarioNovo);
            JOptionPane.showMessageDialog(null, "Salario alterado com Sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Funcionario não existe no sistema", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void AlterarSetor(List<Funcionario> listFunc, String cpf, String novoSetor) {
        Funcionario funcionarioABuscar = null;
        
        for(Funcionario func : listFunc) {
            if(String.valueOf(func.getCpf()).equals(cpf)){
                funcionarioABuscar = func;
                break;
            }
        }
        
        if(funcionarioABuscar != null) {
            funcionarioABuscar.setSetor(novoSetor);
            JOptionPane.showMessageDialog(null, "Setor alterado com Sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Funcionario não existe no sistema", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
