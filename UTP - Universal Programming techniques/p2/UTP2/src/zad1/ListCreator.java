/**
 *
 *  @author Kamiński Patryk S18610
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator <T> { // Uwaga: klasa musi być sparametrtyzowana

    List<T> list1;

    public ListCreator(List<T> list1) {
        this.list1 = list1;
    }


    public static <T> ListCreator <T> collectFrom(List<T> list1) {
        ListCreator listCreator = new ListCreator(list1);
        return listCreator;
    }

    public ListCreator <T> when(Selector<T> sel) {
        List<T> listaWynikowa = new ArrayList<T>();

        for (int i = 0; i < list1.size() ; i++) {
            if (sel.select(list1.get(i))) {
                listaWynikowa.add(list1.get(i));
            }

        }
        list1 = listaWynikowa;
        return this;
    }

    public <O> List <O> mapEvery(Mapper<T, O> map) {
        List<O> listaWynikowa2 = new ArrayList<O>();

        for (int i = 0; i < list1.size(); i++) {
            {
                O o = (O)list1.get(i);
                listaWynikowa2.add(map.map((T) o));
            }
        }

        return listaWynikowa2;
    }
}  
