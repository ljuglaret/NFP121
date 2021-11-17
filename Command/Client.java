
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
        //COPY
        CommandeConcreteCopie commandCopie = new CommandeConcreteCopie(notepad1,0,6);
        commandManager.changerCommande(commandCopie);
        commandManager.lancer();

        //PASTE
        Commande pasteCommand = new CommandeConcreteColler(
                                        notepad2,
                                        commandCopie.getDonneesCopiees()
                            );
        commandManager.changerCommande(pasteCommand);
        commandManager.lancer();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu()+ "\n");
        
        //CUT
        CommandeConcreteCouper commandeCouper = new CommandeConcreteCouper(notepad1, 2, 5);
        commandManager.changerCommande(commandeCouper);
        commandManager.lancer();
        System.out.println("notepad1 : "+notepad1.getContenu());
        System.out.println("notepad2 : "+notepad2.getContenu()+ "\n");
        //PASTE
        Commande pasteCommand1 = new CommandeConcreteColler(
                                        notepad2,
                                        commandeCouper.getCutData()
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
    }
}
