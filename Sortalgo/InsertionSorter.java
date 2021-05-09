
//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;


public class InsertionSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {
    // TODO: Implementierung von InsertionSort
    //for-Schleife geht die ganze Schleife durch,Anfang ist um 1 verlegt damit man j und i vergleichen kann
    for(int i = 1; i < input.length(); ++i){
      int j = i -1;
    //j sollte kleiner i sein damit man bis i durch die ganze schleife einmal durchgeht
      //solange der Wert unterhalb > als wert überhalb swape und geh das Array einen Schritt runter
      //hätte man auch mit einer for und einer if machen können das falls input.get(j).greaterThan(input.get(j+1)
      //nicht erfüllt ist breaked
      while(j >= 0 && input.get(j).greaterThan(input.get(j+1)) ){
        input.swap(j+1,j);
        j--;
      }
    }
  }
}
