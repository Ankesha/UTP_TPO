/**
 * @Author: Patryk Kamiński
 */

package assignment01.test;


import assignment01.Item;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private static final int quantity = 10;

    private Item item1;

    @Before
    public void before() {
        item1 = new Item(quantity);
        Assert.assertEquals(quantity, item1.getQuantity());
    }

    @Test
    public void aggregate() {
        int aggregate = item1.aggregate(null);
        Assert.assertEquals(quantity, aggregate);
        final int init = 20;
        Assert.assertEquals(quantity + init, (int) item1.aggregate(init));
    }

    @Test
    public void deepClone() {
        Item bikeClone = item1.deepClone();
        Assert.assertEquals(item1.getQuantity(), bikeClone.getQuantity());
        Assert.assertNotSame(item1, bikeClone);
    }

}