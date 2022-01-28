/**
 *
 *  @author Kamiński Patryk S18610
 *
 */

package zad1;


public interface Mapper<T, O> { // Uwaga: interfejs musi być sparametrtyzowany

    public O map(T jakisInnyTyp);
}  
