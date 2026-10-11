// Imports nécessaires
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// T extends Document
//
// معناها T لازم تكون Document
// أو class héritée من Document
//
// أمثلة:
// Catalogue<Document>       
// Catalogue<Livre>          
// Catalogue<Dvd>            
// Catalogue<Revue>          

public class Catalogue<T extends Document> {

    // Liste فيها les documents
    private List<T> documents;


    // Constructeur
    public Catalogue() {

        // نخلقو ArrayList فارغة
        documents = new ArrayList<>();
    }


    // Ajouter un document au catalogue
    public void ajouter(T document) {

        documents.add(document);
    }


    // Recherche par titre
    public Optional<T> rechercherParTitre(String titre) {

        // ندورو على جميع documents
        for (T document : documents) {

            // نقارنو titre
            // equalsIgnoreCase = Majuscule/minuscule ما تفرقش
            if (document.getTitre().equalsIgnoreCase(titre)) {

                // إذا لقيناه
                // نرجعو Optional فيها document
                return Optional.of(document);
            }
        }

        // إذا ما لقيناش
        return Optional.empty();
    }


    // Afficher tous les documents
    public void afficherTout() {

        for (T document : documents) {

            // كل document عندها descriptionCourte()
            System.out.println(
                    document.descriptionCourte()
            );
        }
    }
}