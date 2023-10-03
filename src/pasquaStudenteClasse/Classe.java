package pasquaStudenteClasse;

import java.util.Arrays;
import java.lang.Character;
import java.lang.String;

public class Classe {
    private Studente capoClasse;
    private Studente[] studenti;

    public Classe(Studente capoClasse, Studente[] studenti) {
        this.studenti = new Studente[studenti.length];
        this.capoClasse = new Studente(capoClasse);
        this.studenti[0] = this.capoClasse;
        this.studenti = studenti.clone();
    }

    public Studente getCapoClasse() {
        return new Studente(capoClasse);
    }

    public void setCapoClasse(Studente capoClasse) throws Exception {
        this.capoClasse.setCognome(capoClasse.getCognome());
        this.capoClasse.setNome(capoClasse.getNome());
    }

    public Studente[] getStudenti() {
        return studenti.clone() ;
    }

    public void setStudenti(Studente[] studenti) throws Exception {
        if(studenti.length != this.studenti.length) {
            throw new Exception("\nNumero di studenti non valido!");
        } else {
            this.studenti = studenti.clone();
        }
    }

    public void invertiAttributi() throws Exception {

        for (int i = 0; i < studenti.length; i++) {
            String tmp = studenti[i].getNome();
            studenti[i].setNome(studenti[i].getCognome());
            studenti[i].setCognome(tmp);
        }
    }
    public String toString() {
        return "\nStudenti: " + Arrays.toString(studenti);
    }
}
