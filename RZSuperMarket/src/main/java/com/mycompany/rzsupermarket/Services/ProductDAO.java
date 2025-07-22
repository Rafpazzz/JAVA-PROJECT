/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rzsupermarket.Services;

import com.mycompany.rzsupermarket.Domain.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import javax.swing.JOptionPane;



public class ProductDAO {

    public boolean verificaPreenchimento (String name, String marca, String fabricacao, String tipo, String lote, String validade) {
        if (name == null || name.trim().isEmpty() || marca == null || marca.trim().isEmpty() || fabricacao == null || fabricacao.trim().isEmpty()
                || tipo == null || tipo.trim().isEmpty() || lote == null || lote.trim().isEmpty() || validade == null || validade.trim().isEmpty()) {
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
    
    public boolean confirmarValidade(LocalDate validade, LocalDate fabricacao) {
        LocalDate now = LocalDate.now();
        
        if(Period.between(fabricacao,validade).getDays() < 0) {
            JOptionPane.showMessageDialog(null, "Produto com a data Invalida", "Notificação do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }else if(Period.between(now, validade).getDays() < 0) {
            JOptionPane.showMessageDialog(null, "Produto fora da Validade! Descarte Imediatamente", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void addProduct(List productList, Product prod) {
        if(productList.contains(prod)) {
            JOptionPane.showMessageDialog(null, "Produto presente no sistema! Por favor verifique o id do produto", "Notificação do Sistema", JOptionPane.ERROR_MESSAGE);
        }else {
            productList.add(prod);
        }
    }
    
    public void removeProducts(List<Product> productList, String nome, String marca, String lote) {
        for(Product prod : productList) {
            if(prod.getLote() == lote && prod.getNome() == nome && prod.getMark() == marca) {
                productList.remove(prod);
            }
        }
    }
    
    public void removerUmProduto(List<Product> productList, String code) {
        Product prod = null;
        int id = Integer.parseInt(code);
        for(Product prd : productList) {
            if(prd.getId() == id) {
                prod = prd;
                break;
            }
        }
        
        if(prod != null) {
            productList.remove(prod);
        }else {
            JOptionPane.showMessageDialog(null, "Produto nao encontrado", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void buscarProd(List<Product> productList, String code) {
        Product prod = null;
        int id = Integer.parseInt(code);
        for(Product prd : productList) {
            if(prd.getId() == id) {
                prod = prd;
                break;
            }
        }
        
        if(prod != null) {
            JOptionPane.showMessageDialog(null, "Produto: "+prod.toString());
        }else {
            JOptionPane.showMessageDialog(null, "Produto nao encontrado", "Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
