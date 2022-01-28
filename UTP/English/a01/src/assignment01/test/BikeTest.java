/**
 * @Author: Patryk Kamiński
 */

package assignment01.test;


import assignment01.Bike;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BikeTest {

    private static final int mileage = 100;

    private Bike bike1;

    @Before
    public void before() {
        bike1 = new Bike(mileage);
        Assert.assertEquals(mileage, bike1.getMileage());
    }

    @Test
    public void aggregate() {
        int aggregate = bike1.aggregate(null);
        Assert.assertEquals(mileage, aggregate);
        final int init = 20;
        Assert.assertEquals(mileage + init, (int) bike1.aggregate(init));
    }

    @Test
    public void deepClone() {
        Bike bikeClone = bike1.deepClone();
        Assert.assertEquals(bike1.getMileage(), bikeClone.getMileage());
        Assert.assertNotSame(bike1, bikeClone);
    }

}