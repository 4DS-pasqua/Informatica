package pasquaStudenteClasse;

public class Test2 {
    public static void main(String[] args) {
        Studente s = null;
        try {
            s = new Studente("Asd", "Politano");
            System.out.print(s);
        } catch(ArithmeticException e1) {
            System.out.print("Errore aritmetico: " + e1.getMessage());

        } catch(Exception e2) {
            System.out.print("Errore: " + e2.getMessage());
        }
    }
}
