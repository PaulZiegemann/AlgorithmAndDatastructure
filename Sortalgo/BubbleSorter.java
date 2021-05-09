
//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;


public class BubbleSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {
    // TODO: Implementierung von BubbleSort
    //boolean swapped um sicher zu gehen, das keine unnötigen Vergleiche
    //benutzt wurden
    boolean swapped = false;
    // Durchgang durch das ganze Array
    for (int i = 0; i < input.length()-1; i++) {
      //Beim ersten Durchgang wird das Größte Element an die letzte Stelle gesetzt
      //Dadurch kann man beim nächsten Durchgang eine Stelle weniger laufen, weil am Ende
      //schon der größte Wert steht
      for (int j = 0; j < input.length() - i - 1; j++) {
        //ist der wert an Stelle i+1 kleiner als an i müssen diese geswapt werden
        //wurde ein Wert geswapt so stelle den boolean auf true, dadurch kennzeichnet man
        //dass es noch mögliche Werte im Array gibt die noch geswapt werden müssen
        //Gab es einen Durchlauf ohne swaps ist das Array sortiert und alle weiteren Durchläufe
        //würden nur Zeit kosten und keinen Nutzen haben
        if (input.get(j+1).lessThan(input.get(j))) {
          input.swap(j, j + 1);
          swapped = true;
        }
      }
      if(swapped == false){
        break;
      }
    }
  }
}
