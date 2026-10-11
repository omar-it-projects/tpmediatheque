public class MediathequeService {

    private final Catalogue<Document> catalogue;

    public MediathequeService(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public Document rechercher(String titre) throws DocumentIntrouvableException {
        return catalogue.rechercherParTitre(titre)
                .orElseThrow(() -> new DocumentIntrouvableException(titre));
    }

    public void emprunter(String titre) throws DocumentIntrouvableException, DocumentIndisponibleException {
        Document doc = rechercher(titre);

        if (!(doc instanceof Empruntable)) {
            throw new DocumentIndisponibleException(titre + " (ce type de document n'est pas empruntable)");
        }

        ((Empruntable) doc).emprunter();
    }

    public void retourner(String titre) throws DocumentIntrouvableException {
        Document doc = rechercher(titre);
        if (doc instanceof Empruntable) {
            ((Empruntable) doc).retourner();
        }
    }
}