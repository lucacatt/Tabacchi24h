
public class Prodotto {

    private String nomeProdotto;
    private String immProdotto;
    private String prezzo;
    private boolean maggiorenne;
    private int scorte;

    public Prodotto() {
        maggiorenne = false;
        prezzo = "";
        nomeProdotto = "";
        immProdotto = "";
        scorte = 0;
    }

    public int getScorte() {
        return scorte;
    }

    public void setScorte(int scorte) {
        this.scorte = scorte;
    }        

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getImmProdotto() {
        return immProdotto;
    }

    public void setImmProdotto(String Path) {
        this.immProdotto = Path;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isMaggiorenne() {
        return maggiorenne;
    }

    public void setMaggiorenne(boolean maggiorenne) {
        this.maggiorenne = maggiorenne;
    }
}
