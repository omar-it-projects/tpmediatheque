public class DocumentIndisponibleException
        extends MediathequeException {

    public DocumentIndisponibleException(String titre) {

        super(
            "Le document \"" + titre
            + "\" est indisponible car il est deja emprunte."
        );
    }

    public DocumentIndisponibleException(
            String titre,
            Throwable cause) {

        super(
            "Le document \"" + titre
            + "\" est indisponible car il est deja emprunte.",
            cause
        );
    }
}