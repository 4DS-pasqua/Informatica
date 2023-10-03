package pasquaRaccoltaMele;
import pasquaTime.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGestioneRaccolto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dim, selection = -1, index = 0, g = 0, m = 0, a = 0;
        Raccolto giornata;
        Data data;
        Raccolto[] giornateSopraTot;
        float quintali = 0;

        GestioneRaccolto stagioneRaccolta = null;
        Boolean error;

        do {
            try {
                System.out.print("Durata della stagione di raccolta: ");
                dim = input.nextInt();
                stagioneRaccolta = new GestioneRaccolto(dim);
                error = false;
            } catch (Exception e) {
                System.out.print(e.getMessage());
                error = true;
            }
        } while(error);

        do {
            do {
                System.out.print("\n\n 0. Esci" +
                        "\n 1. Aggiungi una giornata di raccolto" +
                        "\n 2. Visualizza raccolto" +
                        "\n 3. Visualizza giorno di raccolta massimo" +
                        "\n 4. Visualizza media raccolto" +
                        "\n 5. Visualizza giornate con raccolto sopra una certa soglia" +
                        "\n 6. Visualizza quintali raccolti in una certa data" +
                        "\n 7. Visualizza totale quintali raccolti" +
                        "\n Seleziona: ");

                do {
                    try {
                        selection = input.nextInt();
                        error = false;
                    } catch (InputMismatchException e) {
                        error = true;
                    }
                } while(error);

            } while(selection < 0 || selection > 7);
            switch(selection) {
                case 2:
                    System.out.print("\n\n" + stagioneRaccolta);
                    break;
                case 3:
                    try {
                        giornata = stagioneRaccolta.massimaRaccolta();
                        System.out.print("\n\nRaccolta massima\nGiorno: " + giornata.getData() + "\nQuintali raccolti: " + giornata.getQuintali());
                    } catch(Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        System.out.print("\n\nInserisci giorno: ");
                        g = input.nextInt();
                    } catch(Exception e) {
                        System.out.print("Dato non valido!");
                    }
                    input = new Scanner(System.in);

                    try {
                        System.out.print("\n\nInserisci mese: ");
                        m = input.nextInt();
                    } catch(Exception e) {
                        System.out.print("Dato non valido!");
                    }
                    input = new Scanner(System.in);

                    try {
                        System.out.print("\n\nInserisci anno: ");
                        a = input.nextInt();
                    } catch(Exception e) {
                        System.out.print("Dato non valido!");
                    }
                    input = new Scanner(System.in);
                    try {
                        System.out.print("\n\nInserisci quintali: ");
                        quintali = input.nextFloat();
                    } catch(Exception e) {
                        System.out.print("Dato non valido!");
                    }
                    input = new Scanner(System.in);
                    try {
                        data = new Data(g, m, a);
                        stagioneRaccolta.setRaccolto(data, quintali);
                    } catch(Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("\n\nMedia raccolto: " + stagioneRaccolta.raccoltaMediaGiornaliera());
                    break;
                case 5:
                    System.out.print("\n\nInserisci numero di quintali da applicare al filtro: ");
                    quintali = input.nextFloat();
                    giornateSopraTot = new Raccolto[stagioneRaccolta.getNumGiornate()];
                    try {
                        index = stagioneRaccolta.giornateSopraTot(quintali, giornateSopraTot);
                    } catch(Exception e) {
                        System.out.print(e.getMessage());
                    }

                    System.out.print("\n\n");
                    for(int i = 0; i < index; i++) {
                        System.out.print("\nGiorno: " + giornateSopraTot[i].getData() + "\nQuintali raccolti: " + giornateSopraTot[i].getQuintali());
                    }
                    break;
                case 6:
                    System.out.print("\n\nInserisci giorno: ");
                    g = input.nextInt();
                    input = new Scanner(System.in);
                    System.out.print("\n\nInserisci mese: ");
                    m = input.nextInt();
                    input = new Scanner(System.in);
                    System.out.print("\n\nInserisci anno: ");
                    a = input.nextInt();
                    input = new Scanner(System.in);
                    try {
                        data = new Data(g, m, a);
                        System.out.print("Quintali raccolti nella data inserita: " + stagioneRaccolta.quintaliData(data));
                    } catch(Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("\n\nTotale raccolto: " + stagioneRaccolta.totRaccolta());
                    break;
            }
        } while(selection != 0);

        System.out.print("\nArrivederci!");
    }
}
