/**
 * @Author: Patryk Kamiński
 */

package assignment01;


public class Item implements IAggregable<Item, Integer>, IDeeplyCloneable<Item> {

    private int quantity;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {

        if (intermediateResult == null)
            return quantity;
        else
            return quantity + intermediateResult;
    }

    @Override
    public Item deepClone() {
        return new Item(quantity);
    }

}