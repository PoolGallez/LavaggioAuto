/**
 * Classe che rappresenta un Veicolo che lava Totalmente la macchina
 * @author Paolo Galletta
 * @version 1.0
 */
public class VeicoloTotale extends Veicolo{
    /**
     * Costruttore
     * @param id identificativo macchina
     * @param la riferimento all'autolavaggio
     */
    public VeicoloTotale(int id, LavaggioAuto la){
        super(id,la); //Richiamo il costruttore della superclasse
    }
}
