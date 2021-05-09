

//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;

/**
 * Implementierung von Insertion-Sort als {@link AbstractSorter}.
 * 
 */
public class ShellSorter extends AbstractSorter {

  @SuppressWarnings("unused")
  private static final int[] GAPS =
      {2147483647, 1131376761, 410151271, 157840433,
              58548857, 21521774, 8810089, 3501671, 1355339, 543749, 213331,
              84801, 27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};

  @Override
  protected <T> void sort(SortableArray<T> input) {
    // TODO: Implementierung von ShellSort
    //gap starten bei der Hälfte und verkleinern sich immer um die Hälfte, solange gaps teilbar sind
    for(int gap = input.length()/2; gap > 0; gap /= 2){
    //gehe gapanfang bis zur ende der Schleife
      for(int i = gap; i < input.length(); i++){
        //speichere gap
        SortableArray <T>.ArrayElement t = input.get(i);
        int j;
        //sortiere nun die Wert in den gaps mit insertionsort
        for( j = i; j >= gap && input.get(j-gap).greaterThan(t); j -= gap){
          input.swap(j, j - gap);
        }
      }
    }

  }
}
