package src.excercise04;

public abstract class PistolBullet extends Bullet {
    public PistolBullet() {

    }

    public PistolBullet(boolean isShot, boolean isDamp, boolean isLoaded) {
        super.isShot = isShot;
        super.isDamp = isDamp;
        super.isLoaded = isLoaded;
    }
}
