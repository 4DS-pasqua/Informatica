package pasquaSegmentoPunto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float x1 = 0, y1= 0, x2 = 1, y2 = 1;
        Punto p1 = new Punto(x1, y1);
        Punto p2 = new Punto(x2, y2);

        Segmento s1 = new Segmento(p1, p2);

        System.out.print("Punti del segmento: " + s1.toString());
        System.out.print("\nLunghezza del segmento: " + s1.calcLunghezza());
        s1.traslaSegmento(1, 4);
        System.out.print("\n\nNuovi punti del segmento traslato: " + s1.toString());
        System.out.print("\nLunghezza del segmento traslato: " + s1.calcLunghezza());
        System.out.print("\n\nPunti vecchi non traslati: " + p1 + ", " + p2);
        p1.traslaPunto(75, 88);
        p2.traslaPunto(88, 75);
        System.out.print("\nPunti vecchi traslati: " + p1 + ", " + p2);
        System.out.print("\n\nPunti del segmento non modificati dalla traslazione dei punti vecchi: " + s1.toString());
    }
}
