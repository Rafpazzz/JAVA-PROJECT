package PetShop.Implementacoes;

import PetShop.Exceptions.MyException;
import PetShop.Objetos.Animal;

import java.io.*;
import java.lang.foreign.ValueLayout;
import java.util.List;

public class AnimalDAO {
    //View visao = new View();

    public void adicionar(Animal animal, List list, File file) {
        if (list.contains(animal)) {
            throw new MyException("Animal ja inserido no sistema");
        } else {
            list.add(animal);
            addArquivo(file, animal);
        }
    }

    public void remover(Long id, List<Animal> list, File file) {
        Animal animalRemuved = null;
        Animal a;
        for(int i = 0; i< list.size(); i++) {
            a = list.get(i);
            if(a.getId().equals(id)) {
                animalRemuved = a;
                break;
            }
        }

        if(animalRemuved == null) {
            throw new MyException("Id invalido. Insira outro valor.");
        }else {
            list.remove(animalRemuved);
            removeArquivo(file, animalRemuved);
        }
    }

    public  void buscarAnima(Long id, List<Animal> list) {
        for (int i =0; i <= list.size(); i++) {
            if(list.get(i).getId().equals(id)) {
                System.out.println(list.get(i));
                break;
            }
        }
    }


    public void addArquivo(File file, Animal animal) {
        try(FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(animal.toString());
            bw.newLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeArquivo(File file, Animal animal) {
        String linha;
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            while((linha=br.readLine()) != null) {
                if(!linha.equals(animal.toString())) {
                    sb.append(linha).append(System.lineSeparator());
                }
            }
            try(FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(sb.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
