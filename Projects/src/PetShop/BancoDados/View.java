package PetShop.BancoDados;

import PetShop.Objetos.Animal;

import java.sql.*;
import java.util.List;

public class View {
    public Connection conectar() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/petshop?useSSL=false&serverTimezone=UTC";
            String usuario = "root";
            String senha = "12345";

            conexao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conecxão realizada com sucesso");

        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }

    public void inserirBanco(Connection conn, Animal animal) {
        try {
            if(conn != null) {
                String comando = "INSERT INTO ANIMAL(ID,NOME,TIPO,RACA) VALUES(?,?,?,?)";

                PreparedStatement sm = conn.prepareStatement(comando);
                sm.setString(1,String.valueOf(animal.getId()));
                sm.setString(2,animal.getNome());
                sm.setString(3,animal.getTipo());
                sm.setString(4,animal.getRaca());

                int i  = sm.executeUpdate();
                System.out.println(i + "Linhas Afetadas");

                sm.close();
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerBanco(Connection conn, Long id) {
        try{
            if(conn != null) {
                String sql = "REMOVE FROM ANIMAL WHERE ID = ?";

                PreparedStatement sm = conn.prepareStatement(sql);
                sm.setString(1,String.valueOf(id));

                sm.close();
                conn.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void lerValoresBanco(Connection conn, List list) {
        String sql = "SELECT * FROM ANIMAL";
        try{
            PreparedStatement sm = conn.prepareStatement(sql);
            ResultSet r = null;
            r = sm.executeQuery();
            while(r.next()) {
                Animal animal = new Animal(r.getString("nome"), r.getLong("id"), r.getString("tipo"), r.getString("raca"));
                list.add(animal);
                System.out.println("Carregando valores");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
