package src.excercise02;

public class TwentyTwo extends AbstractBullet{

    public TwentyTwo() {
    }

    public TwentyTwo(boolean isShot, boolean isDamp, boolean isLoaded) {
        super(isShot, isDamp, isLoaded);
    }

    @Override
    public void shoot() {
        System.out.println("*TwentyTwo Bang*");
    }

    @Override
    public String toString() {
        return "TwentyTwo{" + super.toString();
    }
}
