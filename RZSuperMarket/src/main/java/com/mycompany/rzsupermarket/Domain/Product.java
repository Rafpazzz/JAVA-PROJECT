/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rzsupermarket.Domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Raf
 */
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String nome;
    @Column(name = "mark")
    private String mark;
    @Column(name = "type")
    private String type;
    @Column(name = "value")
    private Double value;
    @Column(name = "validity")
    private LocalDate validity;
    @Column(name = "fabrication")
    private LocalDate fabrication;
    @Column (name = "Lote")
    private String lote;

    public Product(int id, String nome, String mark, String type, Double value, LocalDate validity, LocalDate fabrication, String lote) {
        this.id = id;
        this.nome = nome;
        this.mark = mark;
        this.type = type;
        this.value = value;
        this.validity = validity;
        this.fabrication = fabrication;
        this.lote = lote;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
        final Product other = (Product) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
       final StringBuilder sb = new StringBuilder("test{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", mark='").append(mark).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", value=").append(value);
        sb.append(", validity=").append(validity);
        sb.append(", fabrication=").append(fabrication);
        sb.append(", lote='").append(lote).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public LocalDate getFabrication() {
        return fabrication;
    }

    public void setFabrication(LocalDate fabrication) {
        this.fabrication = fabrication;
    }

}
