import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class View {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuBD");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void salvarBanco(Pessoa pessoa) {
		EntityManager entidade = getEntityManager();
		EntityTransaction tx = null;

		try {
			tx = entidade.getTransaction();
			tx.begin();
			entidade.persist(pessoa);
			tx.commit();
			System.out.println("Aluno salvo com sucesso");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			entidade.close();
		}

	}
}
