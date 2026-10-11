// Revue ترث من Document
//
// ملاحظة:
// Revue ما تعملش implements Empruntable
// خاطر المجلة تتقرا sur place وما تتسلفش

public class Revue extends Document {

    // numéro متاع revue
    private int numero;


    // Constructeur
    public Revue(String titre, int numero) {

        // نبعث titre للـ parent
        super(titre);

        // نخزن numero
        this.numero = numero;
    }


    // Getter
    public int getNumero() {
        return numero;
    }


    // Implementation متاع méthode abstraite
    @Override
    public String descriptionCourte() {

        return "Revue : "
                + getTitre()
                + " - Numero : "
                + numero;
    }
}