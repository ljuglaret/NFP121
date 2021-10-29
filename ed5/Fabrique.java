public interface Fabrique<T>{
  public CollectionI<T> fabriquerUneCollection(String type);
}