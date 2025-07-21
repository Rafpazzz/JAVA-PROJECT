/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rzsupermarket.Services;

import javax.swing.JOptionPane;

/**
 *
 * @author Raf
 */
public class ProductDAO {
    public boolean verificaPreenchimento(String id, String name, String marca, String fabricacao, String tipo, String lote) {
        if(id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty() || marca == null || marca.trim().isEmpty() || fabricacao == null || fabricacao.trim().isEmpty() || 
                tipo == null || tipo.trim().isEmpty() || lote == null || lote.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prencha o campo vazio");
            return false;
        }
        
        return true;
    }
}
