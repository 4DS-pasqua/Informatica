package pasquaStudenteClasse;

public class Studente {
    private String cognome;
    private String nome;

    public Studente(String cognome, String nome) throws Exception {
        setCognome(cognome);
        setNome(nome);
    }

    public Studente(Studente stud) {
        this.cognome = stud.getCognome();
        this.nome = stud.getNome();
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) throws Exception {
        if(isNameValid(cognome)) {
            this.cognome = cognome;
        } else {
            throw new Exception("\nCognome non valido!\n");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(isNameValid(nome)) {
            this.nome = nome;
        } else {
            throw new Exception("\nNome non valido!\n");
        }
    }

    private boolean isNameValid(String str) {
        boolean validity = true;
        int i = 0;
        if(str == null || str.isEmpty() || !Character.isUpperCase(str.charAt(0))) {
            validity = false;
        } else {
            while (i < str.length() && validity) {
                if (Character.isAlphabetic(str.charAt(i)) || Character.isWhitespace(str.charAt(i))) {
                    if(Character.isWhitespace(str.charAt(i))) {
                        if(!Character.isUpperCase(str.charAt(i+1))) {
                            validity = false;
                        }
                    }
                    i++;
                } else {
                    validity = false;
                }
            }
        }
        return validity;
    }

    public String toString() {
        return cognome + " " + nome;
    }
}
