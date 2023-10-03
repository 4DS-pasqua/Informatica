package pasquaRaccoltaMele;
import pasquaTime.Data;

public class GestioneRaccolto {
    private int numGiornate;
    private Raccolto[] magazzino;


    public GestioneRaccolto(int dim) throws Exception {
        if (dim >= 1) {
            magazzino = new Raccolto[dim];
        } else {
            throw new Exception("\nDimensione non valida!");
        }
    }

    public String toString() {
        String str = "";
        if (checkNumGiornate()) {
            int i;
            for (i = 0; i < numGiornate; i++) {
                str = str + (magazzino[i].toString()) + "\n";
            }
        } else {
            str = "\nLa stringa è vuota.";
        }
        return str;
    }

    private void raddoppiaSpazio() {
        Raccolto[] arrayNuovo = new Raccolto[magazzino.length * 2];
        for (int i = 0; i < numGiornate; i++) {
            arrayNuovo[i] = magazzino[i];
        }
        magazzino = arrayNuovo;
    }


    public Raccolto massimaRaccolta() throws Exception {
        Raccolto max;
        if (checkNumGiornate()) {
            max = magazzino[0];
            for (int i = 1; i < numGiornate; i++) {
                if (magazzino[i].getQuintali() > max.getQuintali()) {
                    max = magazzino[i];
                }
            }
        } else {
            throw new Exception("Non sono state inserite giornate di raccolto");
        }
        return max;
    }

    private boolean checkNumGiornate() {
        return (numGiornate > 0);
    }

    public void setRaccolto(Data data, float quintali) throws Exception {
        if (numGiornate >= (magazzino.length)) {
            raddoppiaSpazio();
        }
        if(findData(data) == -1) {
            try {
                magazzino[numGiornate] = new Raccolto(data, quintali);
                numGiornate++;
            } catch (Exception e) {
                throw new Exception("\nDati non validi");
            }
        } else {
            throw new Exception("\nData già presente!");
        }
    }

    public float raccoltaMediaGiornaliera() {
        return totRaccolta() / numGiornate;
    }

    public float totRaccolta() {
        float tot = 0;
        for (int i = 0; i < numGiornate; i++) {
            tot += magazzino[i].getQuintali();
        }
        return tot;
    }

    public int giornateSopraTot(float tot, Raccolto[] giornate) throws Exception {
        int dimLogicaGiornateSopraTot = 0;
        if (checkNumGiornate()) {
            for (int i = 0; i < numGiornate; i++) {
                if (magazzino[i].getQuintali() > tot) {
                    giornate[dimLogicaGiornateSopraTot] = magazzino[i];
                    dimLogicaGiornateSopraTot++;
                }
            }
        } else {
            throw new Exception("Non sono state inserite giornate di raccolto");
        }
        return dimLogicaGiornateSopraTot;
    }

    private int findData(Data data) throws Exception {
        int pos = -1;
        int i = 0;
        boolean trovato = false;
        while (i < numGiornate && !trovato) {
            if (data.confronto(magazzino[i].getData(), data)) {
                pos = i;
                trovato = true;
            }
            i++;
        }
        return pos;
    }

    public float quintaliData(Data data) throws Exception {
        int pos = findData(data);
        if (pos == -1) {
            throw new Exception("\nData non esistente.");
        } else {
            return magazzino[pos].getQuintali();
        }
    }

    public int getNumGiornate() {
        return numGiornate;
    }
}