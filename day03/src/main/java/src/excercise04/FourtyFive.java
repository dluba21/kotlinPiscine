package src.excercise04;

public class FourtyFive extends Bullet {
    public FourtyFive() {
    }

    public FourtyFive(boolean isShot, boolean isDamp, boolean isLoaded) {
        super(isShot, isDamp, isLoaded);
    }

    @Override
    public void shoot() {
        System.out.println("*FourtyFive Bang*");
    }

    @Override
    public String toString() {
        return "FourtyFive{" + super.toString();
    }
}
