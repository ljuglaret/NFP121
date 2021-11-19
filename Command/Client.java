
/**
 * Décrivez votre classe Client ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Client
{
    public static void main(String[] args) {

        Appelant commandManager = new Appelant();
        Recepteur notepad1 = new Recepteur("notepad1","Notepad, how are you?");
        Recepteur notepad2 = new Recepteur("notepad2","");

        System.out.println("etat initial");
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu() + "\n");
        //COPIE depuis np1
        CommandeConcreteCopie commandCopie = new CommandeConcreteCopie(notepad1,0,6);
        commandManager.changerCommande(commandCopie);
        commandManager.lancer();

        //coller sur np2
        Commande commandeColler = new CommandeConcreteColler(
                                        notepad2,
                                        commandCopie.getDonneesCopiees(),
                                        0
                            );
        commandManager.changerCommande(commandeColler);
        commandManager.lancer();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu()+ "\n");
        
        //couper depuis np1
        CommandeConcreteCouper commandeCouper = new CommandeConcreteCouper(notepad1, 2, 5);
        commandManager.changerCommande(commandeCouper);
        commandManager.lancer();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu()+ "\n");
        
        //coller sur np2
        Commande pasteCommand1 = new CommandeConcreteColler(
                                        notepad2,
                                        commandeCouper.getDonneesCoupees(),
                                        0
                                );
        commandManager.changerCommande(pasteCommand1);
        commandManager.lancer();

        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu());

        System.out.println("\n on annule la dernière action ");
        commandManager.annuler();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu());
        System.out.println("\n on annule la nouvelle dernière action");
        commandManager.annuler();     
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu());
        
        //copie depuis np2
        CommandeConcreteCopie commandeCopieNp2 = new CommandeConcreteCopie(notepad2,2,4);
        commandManager.changerCommande(commandeCopieNp2);
        commandManager.lancer();
        //coller sur np1
        Commande commandeColler2 = new CommandeConcreteColler(
                                        notepad1,
                                        commandeCopieNp2.getDonneesCopiees(),
                                        2
                                );
        commandManager.changerCommande(commandeColler2);
        commandManager.lancer();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu());
    }
}
