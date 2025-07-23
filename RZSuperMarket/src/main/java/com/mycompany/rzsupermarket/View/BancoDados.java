package com.mycompany.rzsupermarket.View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.rzsupermarket.Domain.Funcionario;
import com.mycompany.rzsupermarket.Domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Raf
 */
public class BancoDados {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rzSuperMarket");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void adcionarElementoNoBanco(Object o) {
        EntityManager entidade = BancoDados.getEntityManager();
        EntityTransaction tx = null; //funcioes do branco de dados

        try {
            tx = entidade.getTransaction();
            tx.begin();
            entidade.persist(o);
            tx.commit();
            System.out.println("Conecção realizada com suscesso ao Banco de Dados");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            entidade.close();
        }
    }

    public void removerElementoDoBanco(Object o) {
        EntityManager entidade = BancoDados.getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = entidade.getTransaction();
            tx.begin();
            Object obejctMergerd = entidade.merge(o);
            entidade.remove(obejctMergerd);
            tx.commit();
            System.out.println("Conecção realizada com suscesso ao Banco de Dados");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        } finally {
            entidade.close();
        }
    }

    public void carregarListFuncionarios(List<Funcionario> list) {
        EntityManager entidade = BancoDados.getEntityManager();

        try {
            TypedQuery<Funcionario> q = entidade.createQuery("select * from Funcinario a", Funcionario.class);
            List<Funcionario> funcList = q.getResultList();
            list.addAll(funcList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entidade.close();
        }

    }

    public void carregarListProduto(List<Product> list) {
        EntityManager entidade = BancoDados.getEntityManager();

        try {
            TypedQuery<Product> q = entidade.createQuery("select * from Product a", Product.class);
            List<Product> prodList = q.getResultList();
            list.addAll(prodList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entidade.close();
        }
    }

    public void atualizarSalario(Funcionario f, List list) {
        EntityManager entidade = BancoDados.getEntityManager();
        EntityTransaction tx = null;
        if (list.contains(f)) {
            try {
                tx = entidade.getTransaction();
                tx.begin();
                entidade.merge(f);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }

                e.printStackTrace();
            } finally {
                entidade.close();
            }
        }else {
            System.out.println("Funcionario Invalido");
        }

    }
}
