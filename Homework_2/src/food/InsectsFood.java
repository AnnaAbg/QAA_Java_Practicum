package food;

public class InsectsFood extends Food{

    @Override
    public int getFoodValue() {
       return (int) (Math.random() * 10) + 1;
    }
}
