import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TableEntiers implements Iterable<Entier> {
  private Entier[] table;
  private int taille = 0;

  public boolean repOk() {
    if (table == null || taille < 0 || taille > table.length)
      return false;
    for (int i = 0; i < taille; i++) {
      if (table[i] == null)
        return false;
    }
    return true;
  }

  public List<Integer> af() {
    List<Integer> liste = new ArrayList<Integer>();
    for (int i = 0; i < taille; i++) {
      liste.add(table[i].af());
    }
    return liste;
  }

  /**
   * Création d'une table d'entiers.
   * 
   * @param capacite la capacité maximale
   */
  public TableEntiers(int capacite) {
    if (capacite < 0) {
      capacite = 0;
    }
    this.table = new Entier[capacite];
    this.taille = 0;
  }

  public void ajouter(Entier e) throws TablePleineException {
    if (e == null) {
      throw new NullPointerException("null");
    }
    if (estPleine()) {
      throw new TablePleineException("pleine");
    }
    table[taille] = e;
    taille++;
  }

  public void retirer(Entier e) throws TableVideException {
    if (estVide()) {
      throw new TableVideException("La table est vide, on ne peut rien retirer");
    }
    boolean present = false;
    int indiceARetirer = 0;
    for (int i = 0; i < table.length; i++) {
      if (e.equals(table[i])) {
        present = true;
        indiceARetirer = i;
        break;
      }
    }
    if (present) {
      for (int i = indiceARetirer; i < table.length - 1; i++) {
        table[i] = table[i + 1];
      }
      taille--;
    }
  }

  public boolean contient(Entier e) throws TableVideException {

    if (estVide()) {
      throw new TableVideException("La table est vide");
    }
    for (int i = 0; i < table.length; i++) {
      if (e.equals(table[i])) {
        return true;
      }
    }
    return false;

  }

  public int taille() {
    return this.taille;
  }

  public boolean estPleine() {
    return taille == table.length;
  }

  public boolean estVide() {
    return taille == 0;
  }

  public String toString() {
    String res = "[";
    for (int i = 0; i < taille - 1; i++) {
      Entier ent = table[i];
      res = res + (ent.getEntier()) + ", ";
    }
    res += table[taille - 1].getEntier();
    return res + "]";
  }

  public Iterator<Entier> iterator() {
    return new TableIterator();
  }

  private class TableIterator implements Iterator<Entier> {
    private int index = 0;
    private boolean nextOk = (index < table.length - 1); // next() a été effectué au moins une fois avant remove

    public boolean hasNext() { 
      return nextOk;
    }

    public Entier next() {

      if (!hasNext()) {
        throw new IllegalStateException("table pleine");
      }
      index++;
      //System.out.println(table[index - 1].getEntier());
      return table[index - 1];
    }
  
    public void remove() {
        nextOk = index != 0;
        try {
            index--;
            retirer(table[index]);
        }
        catch (TableVideException e) {
            throw new IllegalStateException("table vide");
          }
        }
    }
}
// à compléter
// cette méthode pourrait vous être utile,
// System.arraycopy ,