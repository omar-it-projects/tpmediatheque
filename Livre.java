public class Livre extends Document implements Empruntable {

    private final String auteur;
    private boolean emprunte;

    public Livre(String titre, String auteur) {
        super(titre);
        this.auteur = auteur;
        this.emprunte = false;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String descriptionCourte() {
        return "Livre : " + getTitre() + " - Auteur : " + auteur;
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (emprunte) {
            throw new DocumentIndisponibleException(getTitre());
        }
        emprunte = true;
    }

    @Override
    public void retourner() {
        emprunte = false;
    }

    @Override
    public boolean estEmprunte() {
        return emprunte;
    }
}