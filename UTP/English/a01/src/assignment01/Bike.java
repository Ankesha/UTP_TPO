/**
 * @Author: Patryk Kamiński
 */

package assignment01;


public class Bike implements IAggregable<Bike, Integer>, IDeeplyCloneable<Bike> {

    private int mileage;

    public Bike(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int brandName) {
        this.mileage = brandName;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {

        if (intermediateResult == null)
            return mileage;
        else
            return mileage + intermediateResult;
    }

    @Override
    public Bike deepClone() {
        return new Bike(mileage);
    }

}