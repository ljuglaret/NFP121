
public class FabriqueDeSacs<E> implements Fabrique{
    public CollectionI<E> fabriquerUneCollection(String type){

        if (type == null){
            throw new RuntimeException("il n'y a pas d'ordre sur ");
        }

        if (type.equalsIgnoreCase("SAC")){
            return new Sac<E>();
        }

        else if (type.equalsIgnoreCase("UNIQUE")){
            return new SacAObjetsUniques<E>();
        }

        else if (type.equalsIgnoreCase("ORDONNE")){
            return new SacOrdonneAObjetsUniques<E>();
        }       

        else {
            return new Sac<E>();
        }
    }

}