/**
 * @Author: Patryk Kamiński
 */

package assignment01;


import java.util.ArrayList;
import java.util.List;

public class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult> implements IContainer<TElement, TAggregateResult> {

    private List<TElement> elements;

    public Container(ArrayList<TElement> tElements) {
        this.elements = tElements;
    }

    @Override
    public List<TElement> elements() {
        return this.elements;
    }

    @Override
    public TAggregateResult aggregateAllElements() {

        TAggregateResult tAggregateResult = null;

        for (TElement tElement : this.elements)
            tAggregateResult = tElement.aggregate(tAggregateResult);

        return tAggregateResult;
    }

    @Override
    public TElement cloneElementAtIndex(int index) {
        if (index < 0)
            return null;
        else if (index >= elements.size())
            return null;
        else
            return this.elements.get(index).deepClone();
    }

}