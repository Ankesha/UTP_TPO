package zad2;

import java.util.Comparator;

public class NameComparator implements Comparator<Purchase> {

    public int compare(Purchase p1, Purchase p2) {

        if (p2.getImie().compareTo(p1.getImie()) > 0) {
            return -1;
        } else if (p2.getImie().compareTo(p1.getImie()) < 0) {
            return 1;
        } else if (p2.getImie().equals(p1.getImie())) {

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