package pasquaRaccoltaMele;
import pasquaTime.Data;

public class Raccolto {
    private float quintali;
    private Data data;
    public Raccolto(Data data, float quintali) throws Exception {
        if(quintali < 0) {
            throw new Exception("\nNumero quintali non valido.");
        }
        this.data = data;
        this.quintali = quintali;
    }
    public String toString() {
        return "In data " + this.data + " sono stati raccolti " + this.quintali + " quintali.";
    }
    public float getQuintali() {
        return quintali;
    }
    public Data getData() {
        return data;
    }
    public void setQuintali(float quint){
        this.quintali = quint;
    }
}

