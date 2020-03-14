/**
 *
 *  @author Kamiński Patryk S18610
 *
 */

package zad2;


public class Purchase {

    private String idKlienta;
    private String imie;
    private String towar;
    private double cena;
    private double ilosc;

    public Purchase(String tmp) {

        String[] tmp1 = tmp.split(";");
        idKlienta = tmp1[0];
        imie = tmp1[1];
        towar = tmp1[2];
        cena = Double.parseDouble(tmp1[3]);
        ilosc = Double.parseDouble(tmp1[4]);
    }

    public String getIdKlienta() {
        return idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public double getKoszt() {
        return (cena * ilosc);
    }



    public String toString() {
        return idKlienta + ";" + imie + ";" + towar + ";" + cena + ";" + ilosc;
    }

}