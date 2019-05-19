import os.*;
/**
 * Classe astratta che rappresenta un Veicolo
 * @author Paolo Galletta
 * @version 1.0
 */
public abstract class Veicolo extends Thread{
    /**
     * Id della macchina (inutile)
     */
    protected int id;
    /**
     * Riferimento all'autolavaggio
     */
    protected LavaggioAuto la;
    /**
     * Costruttore veicolo generico
     * @param id identificativo macchina (inutile)
     * @param la riferimento all'autolavaggio
     */
    public Veicolo(int id, LavaggioAuto la){
        this.id = id;
        this.la = la;
    }

    /**
     * @Override toString classe Object
     * @return Rappresentazione veicolo in forma di stringa
     */
    public String toString(){
        return "Sono il "+this.getClass()+" numero: "+id;
    }

    /**
     * Ridefinizione metodo run ereditato da Thread
     */
    public void run(){
        /**
         * Classico esempio di programmazione col culo
         */
        if(this instanceof VeicoloParziale){ //Se è un veicolo parziale
           System.out.println(this+" prenoto il lavaggio dell'esterno");
           la.prenotaParziale();
           System.out.println(this+" attendo che gli schiavi mi lavino la macchina");
            Util.rsleep(2000,4000);
           la.pagaParziale();
           System.out.println(this+" gli do qualche centesimo e me ne vado");
        }else{//Altrimenti
            System.out.println(this+" prenoto il lavaggio totale");
            la.prenotaTotale();
            System.out.println(this+" attendo che i negri,immigrati,clandestini lavino la mia macchina");
            Util.rsleep(2000,4000);
            la.lavaInterno();
            System.out.println(this+" quei delinquenti si sono meritati metà della mia grazia, aspetto che mi lavino gli interni prima di sparare");
            Util.rsleep(2000,4000);
            la.pagaTotale();
            System.out.println(this+" pago 2 centesimi e do una pacca sulla spalla, pulendomi con l'amuchina per evitare che mi contagino");
        }
        System.out.println(la);
    }
}
