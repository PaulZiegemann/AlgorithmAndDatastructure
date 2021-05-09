

//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;

/**
 * Implementierung von Selection-Sort als {@link AbstractSorter}.
 * 
 */
public class SelectionSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {
    // TODO: Implementierung von SelectionSort
    //for-Schleife geht durch das ganze Array
    for (int i = 0; i < input.length(); i++) {
      //minimalIndex auf i gesetzt
      int minIndex = i;

      //for-schleife kann als ein subarray gesehen werden, welche jeden i-schleifen Druchgang größer wird
      for (int j = i + 1; j < input.length(); j++) {
        //es wird nach dem kleinsten Wert gesucht und die Stelle im minIndex gespeichert
        if (input.get(j).lessThan(input.get(minIndex))) {
          minIndex = j;
        }
      }
      //es wird mit der Stelle geswappt, wo der Wert ursprünglich sein müsste, wenn sortiert
      // mit der if wird nochmal geprüft ob ein kleinerer Wert gefunden wurde
      if (minIndex != i) {
        input.swap(minIndex, i);
      }
    }
  }
}
