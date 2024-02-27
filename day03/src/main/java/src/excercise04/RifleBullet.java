package src.excercise04;

public class RifleBullet extends Bullet {
    public RifleBullet() {
    }

    public RifleBullet(boolean isShot, boolean isDamp, boolean isLoaded) {
        super(isShot, isDamp, isLoaded);
    }

    @Override
    public void shoot() {
        System.out.println("*Rifle Bang*");
    }

    @Override
    public String toString() {
        return "RifleBullet{" + super.toString();
    }
}
