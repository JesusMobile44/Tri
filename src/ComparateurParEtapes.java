import java.util.Comparator;
/**
 * Created by simma1733207 on 2018-03-26.
 */
public class ComparateurParEtapes implements Comparator<Livre>{

    @Override
    public int compare(Livre livre1, Livre livre2){
        int maisonEditionCompare = livre1.getMaisonEdition().compareTo(livre2.getMaisonEdition());
        if(maisonEditionCompare==0){
            int auteurCompare = livre1.getAuteur().compareTo(livre2.getAuteur());
            if(auteurCompare==0){
                int titreCompare = livre1.getTitre().compareTo(livre2.getTitre());
                if(titreCompare==0){
                    return livre1.getAnnee()-livre2.getAnnee();
                }
                return titreCompare;
            }
            return auteurCompare;
        }
        return maisonEditionCompare;
    }
}
