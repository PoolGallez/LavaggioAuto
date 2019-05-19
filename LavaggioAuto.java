/**
 * Classe astratta che rappresenta l'autolavaggio  indipendentemente dalla struttura di sincronizzazione
 * @author Paolo Galletta
 * @version 1.0
 */
public abstract class LavaggioAuto{
    /**
     * Costanti che definiscono la massima capienza per zona
     */
    public final int MAX_A = 8;
    public final int MAX_B = 4;

    /**
     * Numero di spazi liberi nelle varie zone
     */
    protected int autoA;
    protected int autoB;

    /**
     * Numero di macchine Parziali(Totali) in attesa
     */
    protected int parzInAttesa;
    protected int totInAttesa;

    /**
     * Costruttore
     */
    public LavaggioAuto(){
        autoA = MAX_A;
        autoB = MAX_B;
        parzInAttesa = totInAttesa = 0;
    }

    /**
     * Metodi da implementare
     */
    public abstract void prenotaParziale();
    public abstract void prenotaTotale();
    public abstract void pagaParziale();
    public abstract void pagaTotale();
    public abstract void lavaInterno();

    /**
     * @Override toString classe Object
     * @return Lo stato dell'autolavaggio in forma di stringa
     */
    public String toString(){
        return "Posti liberi in A: "+autoA+"\n"+
            "Posti liberi in B: "+autoB+"\n"+
            "auto parziali in attesa: "+parzInAttesa+"\n"+
            "auto totali in attesa: "+totInAttesa+"\n";
    }
}
