package src.excercise04;

import src.excercise03.GlobalCounter;

public abstract class Bullet {

    protected boolean isShot = false;
    protected boolean isDamp = false;
    protected boolean isLoaded = false;
    private Integer id = GlobalCounter.getNextInt();
    public abstract void shoot();

    public Bullet() {
    }

    public Bullet(boolean isShot, boolean isDamp, boolean isLoaded) {
        this.isShot = isShot;
        this.isDamp = isDamp;
        this.isLoaded = isLoaded;
    }

    public boolean isShotPossible() {
        return isLoaded && !isShot && !isDamp;
    }
    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public boolean isDamp() {
        return isDamp;
    }

    public void setDamp(boolean damp) {
        isDamp = damp;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public static final boolean SHOT = true;
    public static final boolean DAMP = true;
    public static final boolean LOADED = true;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", isShot=" + isShot +
                ", isDamp=" + isDamp +
                ", isLoaded=" + isLoaded +
                '}';
    }
}
