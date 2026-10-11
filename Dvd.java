public class Dvd extends Document implements Empruntable {

    private final String realisateur;
    private boolean emprunte;

    public Dvd(String titre, String realisateur) {
        super(titre);
        this.realisateur = realisateur;
        this.emprunte = false;
    }

    public String getRealisateur() {
        return realisateur;
    }

    @Override
    public String descriptionCourte() {
        return "DVD : " + getTitre() + " - Réalisateur : " + realisateur;
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