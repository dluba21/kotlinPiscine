package src.excercise04;

public class ThreeEighty extends PistolBullet {
    public ThreeEighty() {
    }
    public ThreeEighty(boolean isShot, boolean isDamp, boolean isLoaded) {
        super(isShot, isDamp, isLoaded);
    }

    @Override
    public void shoot() {
        System.out.println("*ThreeEighty Bang*");
    }

    @Override
    public String toString() {
        return "ThreeEighty{" + super.toString();
    }
}
