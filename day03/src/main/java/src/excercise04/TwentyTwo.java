package src.excercise04;

public class TwentyTwo extends Bullet {

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
