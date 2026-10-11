// Collection باش نخدمو على مجموعة elements
import java.util.Collection;


public class Utilitaire {


    // Méthode générique
    //
    // T لازم تكون Comparable
    // باش نجموا نستعملو compareTo()

    public static <T extends Comparable<? super T>> T max(
            Collection<T> elements) {


        // إذا collection فارغة
        // ما عناش max
        if (elements == null || elements.isEmpty()) {

            throw new IllegalArgumentException(
                    "La collection ne doit pas etre vide."
            );
        }


        // نعتبرو أول élément هو max مؤقتاً
        T maximum =
                elements.iterator().next();


        // ندورو على بقية العناصر
        for (T element : elements) {

            // نقارنو العنصر الحالي بالـ maximum
            if (element.compareTo(maximum) > 0) {

                // إذا الحالي أكبر
                // يصبح هو maximum
                maximum = element;
            }
        }


        // نرجعو أكبر élément
        return maximum;
    }
}