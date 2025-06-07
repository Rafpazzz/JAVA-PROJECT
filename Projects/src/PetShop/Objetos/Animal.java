package PetShop.Objetos;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {
    private String nome;
    private Long id;
    private String tipo;
    private String raca;

    public Animal(String nome, String tipo, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.id = ThreadLocalRandom.current().nextLong(0, 1000);
    }

    public Animal(String nome, Long id, String tipo, String raca) {
        this.nome = nome;
        this.id = id;
        this.tipo = tipo;
        this.raca = raca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal: ");
        sb.append("nome= ").append(nome);
        sb.append(", id= ").append(id);
        sb.append(", tipo= ").append(tipo);
        sb.append(", raca= ").append(raca);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
