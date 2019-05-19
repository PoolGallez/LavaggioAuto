/**
 * Classe che rappresenta un veicolo che deve lavare solo gli Esterni
 * @author Paolo Galletta
 * @version 1.0
 */
public class VeicoloParziale extends Veicolo{
    /**
     * Costruttore
     * @param id identificativo macchina
     * @param la Riferimento all'autolavaggio
     */
    public VeicoloParziale(int id, LavaggioAuto la){
        super(id,la); //Richiamo il costruttore della superclasse
    }
}
