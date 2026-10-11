import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Livre livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry");
        Dvd dvd = new Dvd("Inception", "Christopher Nolan");
        Revue revue = new Revue("Science et Vie", 125);

        Catalogue<Document> catalogue = new Catalogue<>();
        catalogue.ajouter(livre);
        catalogue.ajouter(dvd);
        catalogue.ajouter(revue);

        MediathequeService service = new MediathequeService(catalogue);

        System.out.println("=== CATALOGUE ===");
        catalogue.afficherTout();

        System.out.println("\n=== RECHERCHE ===");
        try {
            Document trouve = service.rechercher("Inception");
            System.out.println("Trouvé : " + trouve.descriptionCourte());
        } catch (DocumentIntrouvableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== EMPRUNT ===");
        try {
            service.emprunter("Le Petit Prince");
            System.out.println("Livre emprunté : " + livre.estEmprunte());

            service.retourner("Le Petit Prince");
            System.out.println("Livre retourné : " + !livre.estEmprunte());
        } catch (MediathequeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== DOUBLE EMPRUNT (exception attendue) ===");
        try {
            service.emprunter("Inception");
            service.emprunter("Inception"); // doit lever l'exception
        } catch (MediathequeException e) {
            System.out.println("Exception correctement levée : " + e.getMessage());
        }

        System.out.println("\n=== BONUS MAX ===");
        List<Document> documents = Arrays.asList(livre, dvd, revue);
        Document maximum = Utilitaire.max(documents);
        System.out.println("Max selon le titre : " + maximum.getTitre());
    }
}