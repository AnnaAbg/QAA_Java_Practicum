package food;

public class AquaticPlants extends Food {
    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 1;
    }
}
