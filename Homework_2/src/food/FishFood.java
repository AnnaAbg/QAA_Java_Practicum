package food;

public class FishFood extends Food{

    @Override
    public int getFoodValue() {
     return (int) (Math.random() * 10) + 1;
    }
}
