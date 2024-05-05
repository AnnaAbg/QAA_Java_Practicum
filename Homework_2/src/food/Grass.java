package food;

public class Grass extends Food {

    @Override
    public int getFoodValue() {
        return (int) (Math.random() * 10) + 3;
    }
}
