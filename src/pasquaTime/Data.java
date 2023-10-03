package pasquaTime;

public class Data {
    private int giorno;
    private int mese;
    private int anno;
    private boolean bisestile;

    public Data(int giorno , int mese , int anno) throws Exception {
        if(dataValida(giorno, mese, anno)) {
            this.giorno  = giorno;
            this.mese  = mese;
            this.anno= anno;
        }else{
            throw new Exception("\nData non valida");
        }

    }

    public void setGiorno(int giorno) {
        if(dataValida(giorno, this.mese, this.anno)){
            this.giorno = giorno;
        }
    }

    public void setMese(int mese){
        if(dataValida(this.giorno, mese, this.anno)){
            this.mese  = mese;
        }
    }

    public void setAnno(int anno){
        if(dataValida(this.giorno, this.mese, anno)){
            this.anno = anno;
        }
    }

    public String toString(){
        return this.giorno + "/" + this.mese + "/" + this.anno;
    }


    public boolean bisestile(int aaaa){
        boolean bisestile = false;
        if(aaaa%4==0){
            bisestile = true;
            if(aaaa%100==0){
                if(aaaa%400!=0){
                    bisestile = false;
                }
            }
        }
        return bisestile;
    }


    private boolean dataValida(int gg, int mm, int aaaa){
        boolean valida = false;
        int[] mesiNonBisestile = new int[12];
        mesiNonBisestile[0] = 31; mesiNonBisestile[1] = 28; mesiNonBisestile[2] = 31; mesiNonBisestile[3] = 30; mesiNonBisestile[4] = 31; mesiNonBisestile[5] = 30; mesiNonBisestile[6] = 31; mesiNonBisestile[7] = 31; mesiNonBisestile[8] = 30; mesiNonBisestile[9] = 31; mesiNonBisestile[10] = 30; mesiNonBisestile[11] = 31;

        int[] mesiBisestile = new int[12];
        mesiBisestile[0] = 31; mesiBisestile[1] = 28; mesiBisestile[2] = 31; mesiBisestile[3] = 30; mesiBisestile[4] = 31; mesiBisestile[5] = 30; mesiBisestile[6] = 31; mesiBisestile[7] = 31; mesiBisestile[8] = 30; mesiBisestile[9] = 31; mesiBisestile[10] = 30; mesiBisestile[11] = 31;

        if(mm>=1 && mm<= 12){
            if(bisestile(aaaa)){
                if(gg>=1 && gg<= mesiBisestile[mm-1]){
                    valida = true;
                }
            }else{
                if(gg>=1 && gg<= mesiNonBisestile[mm-1]){
                    valida = true;
                }
            }

        }
        return valida;
    }


    public int getG(){
        return this.giorno;
    }


    public int getM(){
        return this.mese;
    }


    public int getA(){
        return this.anno;
    }

    public boolean confronto(Data data, Data data2)throws Exception {
        boolean flag = false;
        if(data.dataValida(data.getG(), data.getM(), data.getA()) && data2.dataValida(data2.getG(), data2.getM(), data2.getA())){
            if(data.getG() ==data2.getG() && data.getM() == data2.getM() && data.getA() == data2.getA()){
                flag = true;
            }
        }else{
            throw new Exception("\nData non valida");
        }
        return flag;
    }

}
