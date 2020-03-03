package DrawableItmes;

public class DrawableObject {
    private int x;
    private int y;
    private Drawable object;

    public DrawableObject(Drawable object, int x, int y) {
        this.object = object;
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Drawable getObject(){
        return object;
    }
}
