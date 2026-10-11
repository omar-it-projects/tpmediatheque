public class DocumentIntrouvableException
        extends MediathequeException {

    public DocumentIntrouvableException(String titre) {

        super(
            "Aucun document ne porte le titre \""
            + titre + "\"."
        );
    }

    public DocumentIntrouvableException(
            String titre,
            Throwable cause) {

        super(
            "Aucun document ne porte le titre \""
            + titre + "\".",
            cause
        );
    }
}