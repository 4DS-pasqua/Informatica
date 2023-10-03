package pasquaSegmentoPunto;
import java.lang.Math;

public class Segmento {
    private Punto p1;
    private Punto p2;

    public Segmento(Punto p1, Punto p2) {
        this.p1 = new Punto(p1);
        this.p2 = new Punto(p2);
    }

    public String toString() {
        return "\nPunto 1: " + p1.toString() + "\nPunto 2: " + p2.toString();
    }

    public double calcLunghezza() {
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
    }

    public void traslaSegmento(float deltaX, float deltaY) {
        p1.traslaPunto(deltaX, deltaY);
        p2.traslaPunto(deltaX, deltaY);
    }

    public Punto getP1() {
        return new Punto(p1);
    }

    public Punto getP2() {
        return new Punto(p2);
    }

    public void setP1(float x, float y) {
        p1.setX(x);
        p1.setY(y);
    }

    public void setP2(float x, float y) {
        p2.setX(x);
        p2.setY(y);
    }
}
