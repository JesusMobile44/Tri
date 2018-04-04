
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livre> liste1 = new ArrayList<>();
        ArrayList<Livre> liste2 = new ArrayList<>();
        ArrayList<Livre> liste3 = new ArrayList<>();
        TreeSet<Livre> liste4 = new TreeSet<>();
        TreeSet<Livre> liste5 = new TreeSet<>(new ComparateurParEtapes());

        remplir(liste1);
        remplir(liste2);
        remplir(liste3);
        remplir(liste4);
        remplir(liste5);

        triage(liste1);
        Collections.sort(liste2);
        Collections.sort(liste3,new ComparateurParEtapes());

        System.out.println("===== Liste 1 =====");
        System.out.println("- Tri par année");
        affichageAnnee(liste1);
        System.out.println("===== Liste 2 =====");
        System.out.println("- Collections.sort sans le comparateur (en ordre d'année)");
        affichageAnnee(liste2);
        System.out.println("===== Liste 3 =====");
        System.out.println("- Collections.sort avec le comparateur");
        affichageEtape(liste3);
        System.out.println("===== Liste 4 =====");
        System.out.println("- TreeSet par année");
        affichageAnnee(liste4);
        System.out.println("===== Liste 5 =====");
        System.out.println("- TreeSet avec Comparator");
        affichageEtape(liste5);
    }

    public static void remplir(Collection<Livre> liste){
        liste.add(new Livre(2018,"Github","OuiOuiBaguette","Simon Belley","WonderJAM","5346"));
        liste.add(new Livre(1,"Oui","Oui","Oui","Oui","1"));
        liste.add(new Livre(2000,"Les Aventures de Jean-Jaques Ponpinou","Jouet rose dans le tirroir à ta mère", "Simon Belley", "Ok", "1178"));
        liste.add(new Livre(2001,"Les Aventures de Jean-Jaques Ponpinou","La revanche","Simon Belley","Ok","1179"));
        liste.add(new Livre(1981,"Frankenstein et Michael Jackson","Thriller","Kim Lavoie","CégepDeJonquière","4112"));
        liste.add(new Livre(1931,"That hitler guy looks alright","He even has a cool stach","Samba Diakite","Afrikanologie","6969"));
        liste.add(new Livre(1892,"Dab On The Hater","Bitch","Jake Paul","Team 10","7802"));
        liste.add(new Livre(1991,"Boku no Piko","A familly friendly film","Ching-Chong Desu","Nickelodeon","9402"));
        liste.add(new Livre(9999,"Ant farming for Globorks","An easy guide","QWVuUGUTRj81237","Ues","9999999"));
        liste.add(new Livre(0,"Bible","A jesus Fanfiction","Father","Nazareth","0"));
    }
    public static void triage(ArrayList<Livre> liste){
        int smallest;
        Livre livre;
        for(int i=0; i<liste.size(); i++){
            livre = liste.get(i);
            smallest=i;
            for (int j=i; j<liste.size(); j++) {
                if (liste.get(j).compareTo(liste.get(smallest)) < 0) {
                    livre = liste.get(j);
                    smallest=j;
                }
            }
            liste.remove(smallest);
            liste.add(i, livre);
        }
    }
    public static void affichageAnnee(Collection<Livre> liste){
        for (Livre livre : liste) {
            System.out.println("-"+livre.getAnnee()+", "+livre.getTitre()+", "+livre.getSousTitre()+", "+livre.getAuteur()+", "+livre.getMaisonEdition()+", "+livre.getIsbn());
        }
        System.out.println("=================================================================");
    }

    public static void affichageEtape(Collection<Livre> liste){
        for (Livre livre : liste) {
            System.out.println("-"+livre.getMaisonEdition()+", "+livre.getAuteur()+", "+livre.getTitre()+", "+livre.getSousTitre()+", "+livre.getAnnee()+", "+livre.getIsbn());
        }
        System.out.println("=================================================================");
    }
}
