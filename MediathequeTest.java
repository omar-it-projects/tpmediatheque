import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class MediathequeTest {

    // ==========================
    // TEST 1 : EMPRUNT NORMAL
    // ==========================
    @Test
    void empruntNominal() throws DocumentIndisponibleException {

        Livre livre = new Livre("Java", "Auteur");

        assertFalse(livre.estEmprunte());

        livre.emprunter();

        assertTrue(livre.estEmprunte());
    }


    // ==========================
    // TEST 2 : DOUBLE EMPRUNT
    // ==========================
    @Test
    void doubleEmprunt() throws DocumentIndisponibleException {

        Livre livre = new Livre("Java", "Auteur");

        livre.emprunter();

        assertThrows(
                DocumentIndisponibleException.class,
                () -> livre.emprunter()
        );
    }


    // ==========================
    // TEST 3 : RECHERCHE
    // ==========================
    @Test
    void rechercheInfructueuse() {

        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(new Livre("Java", "Auteur"));

        Optional<Document> resultat = catalogue.rechercherParTitre("Python");

        assertTrue(resultat.isEmpty());
    }


    // ==========================
    // TEST 4 : DOCUMENT INTROUVABLE
    // ==========================
    @Test
    void serviceEmpruntDocumentIntrouvable() {

        Catalogue<Document> catalogue = new Catalogue<>();
        MediathequeService service = new MediathequeService(catalogue);

        assertThrows(
                DocumentIntrouvableException.class,
                () -> service.emprunter("Inexistant")
        );
    }


    // ==========================
    // TEST 5 : DOCUMENT INDISPONIBLE
    // ==========================
    @Test
    void serviceEmpruntDocumentIndisponible() throws Exception {

        Catalogue<Document> catalogue = new Catalogue<>();
        catalogue.ajouter(new Livre("Java", "Auteur"));

        MediathequeService service = new MediathequeService(catalogue);

        service.emprunter("Java");

        assertThrows(
                DocumentIndisponibleException.class,
                () -> service.emprunter("Java")
        );
    }
}