
//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;

public class MergeSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {

    // Diese methode ist fertig implementiert!
    // Hier ist nichts zu ändern!
    if (input.length() >= 2) {
      int m = input.length() / 2;

      // sortiere erste Hälfte rekursiv
      var left = input.subArray(0, m - 1);
      sort(left);

      // sortiere zweite Hälfte rekursiv
      var right = input.subArray(m, input.length() - 1);
      sort(right);

      // Mische Ergebnisse zusammen
      merge(left, right, input);
    }
  }

  private <T> void merge(SortableArray<T> left, SortableArray<T> right, SortableArray<T> mergeTo) {

    //erstelle cursor
    //l = cursor linkes subarray
    int l = 0;
    //r = cursor rechtes subarray
    int r = 0;
    //m stelle des Mergearrays
    int m = 0;

    //solange sich die cursor in den subarrays befinden
    while(l < left.length() && r < right.length()){
      //Vergleiche linkes subarray mit rechtem, wenn linker Wert kleiner als rechter Wert
      //Setze Wert in das Mergearray, sonst rechter Wert
      if(left.get(l).lessOrEqual(right.get(r))){
        mergeTo.put(m,left.get(l));
        l++;
      }else{
        mergeTo.put(m,right.get(r));
        r++;
      }
      m++;
    }
    //Weitere while für die restlichen Werte im linken Subarray
    while(l < left.length()){
      mergeTo.put(m,left.get(l));
      l++;
      m++;
    }
    //Weitere while für die restlichen Werte im rechten Subarray
    while(r < right.length()){
      mergeTo.put(m,right.get(r));
      r++;
      m++;
    }
  }
}
