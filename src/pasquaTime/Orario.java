package pasquaTime;

public class Orario {
    int s;
    public Orario(int s, int m, int h) throws Exception {
        if(s > 59 || s < 0) {
            throw new Exception("\nIl valore dei secondi va da 0 a 59!\n");
        } else {
            this.s += s;
        }
        if(m > 59 || m < 0) {
            throw new Exception("\nIl valore dei minuti va da 0 a 59!\n");
        } else {
            this.s += m * 60;
        }
        if(h > 23 || h < 0) {
            throw new Exception("\nIl valore delle ore va da 0 a 23!\n");
        } else {
            this.s += h * 3600;
        }
    }

    public String toString() {
        String str = "Ora: ";
        str += getH() + ":";
        str += getM() + ":";
        str += getS();
        return str;
    }

    public int getS() {
        return ((s % 3600) % 60);
    }

    public int getM() {
        return ((s % 3600) / 60);
    }

    public int getH() {
        return s / 3600;
    }

    public int sAfterMidnight() {
        return s;
    }

    public int mAfterMidnight() {
        return getH()*60 + getM();
    }

    public int hAfterMidnight() {
        return getH();
    }

    public void addSeconds(int seconds) {
        this.s += seconds;
        fixTime();
    }

    public void addMinutes(int minutes) {
        addSeconds(minutes*60);
    }

    public void addHours(int hours) {
        addSeconds(hours*3600);
    }

    private void fixTime() {
        if(s > 86400) {
            s -= 86400;
        }
    }
}