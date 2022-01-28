package zad2;

import java.util.Comparator;

public class PriceComparator implements Comparator<Purchase> {

    public int compare(Purchase p1, Purchase p2) {

        if (p1.getKoszt() > p2.getKoszt()) {
            return -1;
        } else if (p1.getKoszt() < p2.getKoszt()) {
            return 1;
        } else if(p1.getKoszt() == p2.getKoszt()) {
            if (p2.getIdKlienta().compareTo(p1.getIdKlienta()) > 0) {
                return -1;
            }

            if (p2.getIdKlienta().compareTo(p1.getIdKlienta()) < 0) {
                return 1;
            }

            else return -1;
        }
        else return 0;
    }

}

