package pasquaSegmentoPunto;

public class Punto {
    private float x;
    private float y;

    Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y){
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    void traslaPunto(float deltaX, float deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

}
