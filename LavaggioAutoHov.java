import os.*;
/**
 * Classe che rappresenta l'autolavaggio e utilizza il monitor di Hoavre
 * @author Paolo Galletta
 * @version 1.0
 */
public class LavaggioAutoHov extends LavaggioAuto{
    private Monitor mon;
    private Monitor.Condition attParz;
    private Monitor.Condition attTot;
    public LavaggioAutoHov(){
        super();
        mon = new Monitor();
        attParz = mon.new Condition();
        attTot = mon.new Condition();
    }
    
    public void prenotaParziale(){
        mon.mEnter();
        if((autoA <= 0 && totInAttesa > 0) || (autoA >0  && totInAttesa >0)){
            System.out.println("Auto Parziale in attesa");
            parzInAttesa++;
            attParz.cWait();
            parzInAttesa--;
            System.out.println("Auto parziale si è liberato un posto");
        }
        //Non ci sono Tot in attesa e c'è un posto in A
        autoA--;
        mon.mExit();
    }

    public void prenotaTotale(){
        mon.mEnter();
        if((autoA <= 0 && autoB <= 0) || (autoA >0 && autoB <=0) || (autoA <=0 && autoB >0) ){
            System.out.println("Auto Totale in attesa che gli schiavi si diano una mossa");
            totInAttesa++;
            System.out.println(this);
            attTot.cWait();
            totInAttesa--;
            System.out.println("Auto totale si e liberato un posto");
        }
        //Si è liberato un posto
        autoA--;
        autoB--;
        System.out.println(this);
        mon.mExit();
    }

    public void pagaParziale(){
        mon.mEnter();
        autoA++;
        if(totInAttesa>0 && autoB>0 && autoA >0){
            attTot.cSignal();
            System.out.println("Auto parziale sveglio un totale perche c'e qualcuno di loro in attesa");
        }
        else{
            attParz.cSignal();
            System.out.println("Auto parziale sveglio un parziale perche non c'e nessun totale in attesa");
        }
        System.out.println(this);
        mon.mExit();
    }

    public void pagaTotale(){
        mon.mEnter();
        autoB++;
        if(totInAttesa>0){
            attTot.cSignal();
            System.out.println("Auto totale sveglio un altro totale perchè c'è qualcuno in attesa");
        }
        else{
            attParz.cSignal();
            System.out.println("Auto totale sveglio un parziale perché non c'e nessun totale in attesa");
        }
        System.out.println(this);
        mon.mExit();
    }

    public void lavaInterno(){
        mon.mEnter();
        autoA++;
        mon.mExit();
    }

    public static void main(String[]args){
        LavaggioAuto la = new LavaggioAutoHov();
        System.out.println(la);
        int i;
        for(i= 0;i<25;i++){
            if(Math.random()*100 >=50)
                new VeicoloParziale(i,la).start();
            else
                new VeicoloTotale(i,la).start();
            Util.rsleep(100,1000);
        }
    }
}


