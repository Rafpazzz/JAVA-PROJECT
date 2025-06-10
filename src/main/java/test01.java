
public class test01 {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa("Rafael", 21);
		View banco = new View();
		
		banco.salvarBanco(pessoa);
	}
}
