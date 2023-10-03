package pasquaTime;
import java.util.Scanner;

public class OrarioTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s, m, h, selection;
        Orario orario1 = null;
        Boolean error;

        do {
            error = false;
            try {
                System.out.print("Numero di secondi: ");
                s = input.nextInt();
                System.out.print("\nNumero di minuti: ");
                m = input.nextInt();
                System.out.print("\nNumero di ore: ");
                h = input.nextInt();
                orario1 = new Orario(s, m, h);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                error = true;
            }
        } while(error);

        do {
            do {
                System.out.print("\n\n0. Esci" +
                        "\n1. Visualizza orario" +
                        "\n 2. Visualizza secondi" +
                        "\n 3. Visualizza minuti" +
                        "\n 4. Visualizza ore" +
                        "\n 5. Visualizza secondi passati da mezzanotte" +
                        "\n 6. Visualizza minuti passati da mezzanotte" +
                        "\n 7. Visualizza ore passate da mezzanotte" +
                        "\n 8. Aggiungi secondi" +
                        "\n 9. Aggiungi minuti" +
                        "\n 10. Aggiungi ore" +
                        "\n Seleziona: ");

                selection = input.nextInt();
            } while(selection < 0 || selection > 10);
            switch(selection) {
                case 1:
                    System.out.print("\n\n" + orario1.toString());
                    break;
                case 2:
                    System.out.print("\n\nNumero di secondi: " + orario1.getS());
                    break;
                case 3:
                    System.out.print("\n\nNumero di minuti: " + orario1.getM());
                    break;
                case 4:
                    System.out.print("\n\nNumero di ore: " + orario1.getH());
                    break;
                case 5:
                    System.out.print("\n\nNumero di secondi dopo mezzanotte: " + orario1.sAfterMidnight());
                    break;
                case 6:
                    System.out.print("\n\nNumero di minuti dopo mezzanotte: " + orario1.mAfterMidnight());
                    break;
                case 7:
                    System.out.print("\n\nNumero di ore dopo mezzanotte: " + orario1.hAfterMidnight());
                    break;
                case 8:
                    System.out.print("\n\nInserisci secondi da aggiungere: ");
                    orario1.addSeconds(input.nextInt());
                    break;
                case 9:
                    System.out.print("\n\nInserisci minuti da aggiungere: ");
                    orario1.addMinutes(input.nextInt());
                    break;
                case 10:
                    System.out.print("\n\nInserisci ore da aggiungere: ");
                    orario1.addHours(input.nextInt());
                    break;
            }
        } while(selection != 0);

        System.out.print("\nArrivederci!");
    }
}