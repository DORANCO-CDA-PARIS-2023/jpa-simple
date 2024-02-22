package doranco;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("cours");
        EntityManager entityManager = EntityManagerFactory.createEntityManagerFactory();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Article newArticle = new Article();
        newArticle.setTitle("Titre 1");
        entityManager.persist(newArticle);

        transaction.commit();

        Article article = entityManager.find(Article.class, 1L);
        System.out.println(article);

        entityManagerFactory.close();
    }
}
