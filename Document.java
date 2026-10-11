// Document هي class abstraite
// يعني ما نجمش نعمل:
// Document d = new Document(...);

public abstract class Document implements Comparable<Document> {

    private String titre;


    public Document(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public abstract String descriptionCourte();

    // Comparable تسمح لنا نقارنو بين Document
    // هنا نقارنو حسب titre
    @Override
    public int compareTo(Document autre) {

        // compareTo ترجع:
        // < 0 إذا this أصغر من autre
        // = 0 إذا كيف كيف
        // > 0 إذا this أكبر من autre

        return this.titre.compareToIgnoreCase(autre.titre);
    }

    // toString تستعمل كي نطبعو object
    @Override
    public String toString() {
        return descriptionCourte();
    }
}