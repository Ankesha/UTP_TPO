/**
 * @Author: Patryk Kamiński
 */

package assignment01.test;


import assignment01.Container;

import assignment01.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ContainerTest {

    private static final ArrayList<Item> itemsList = new ArrayList<Item>();

    private Container<Item, Integer> container1;

    @Before
    public void before() {
        itemsList.add(new Item(5));
        itemsList.add(new Item(10));

        container1 = new Container<Item, Integer>(itemsList);
    }

    @Test
    public void aggregateAllElements() {
        int aggregate = container1.aggregateAllElements();
        int aggregateItem = itemsList.get(0).aggregate(itemsList.get(1).aggregate(null));
        Assert.assertEquals(aggregate, aggregateItem);
    }

    @Test
    public void cloneElementAtIndex() {
        Item itemClone1 = container1.cloneElementAtIndex(0);

        Assert.assertEquals(itemClone1.getQuantity(), container1.elements().get(0).getQuantity());
        Assert.assertNotSame(container1.elements().get(0), itemClone1);
    }

}