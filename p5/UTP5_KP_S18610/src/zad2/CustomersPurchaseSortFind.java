/**
 *
 *  @author Kamiński Patryk S18610
 *
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomersPurchaseSortFind {

    private ArrayList <Purchase> list;

    public CustomersPurchaseSortFind() {
        list = new ArrayList <>();
    }

    public void readFile(String path) {

        try {
            Scanner scan = new Scanner(new File(path));

            while(scan.hasNext()) {
                list.add(new Purchase(scan.nextLine()));
            }
            scan.close();
        } catch (FileNotFoundException e) {}
    }

    public void showSortedBy(String sortby) {

        ArrayList <Purchase> tmp = new ArrayList<>(list);
        System.out.println(sortby);
        if(sortby.equals("Nazwiska")) {
            Collections.sort(tmp, new NameComparator());
            for(int i = 0; i < tmp.size(); i++)
                System.out.println(tmp.get(i));
        }

        if(sortby.equals("Koszty")) {
            Collections.sort(tmp, new PriceComparator());
            for (int i = 0; i < tmp.size(); i++)
                System.out.println(tmp.get(i) + " (koszt: " + tmp.get(i).getKoszt() + ")");
        }
        System.out.println();
    }

    public void showPurchaseFor(String client) {

        System.out.println("Klient " + client);
        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).getIdKlienta().equals(client))
                System.out.println(list.get(i));
        }
        System.out.println();
    }
}