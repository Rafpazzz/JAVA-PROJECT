import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

	@Id
	public String nome;
	public int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
}
