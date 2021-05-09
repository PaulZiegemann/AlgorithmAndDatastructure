

//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;

/**
 * Implementierung von Shaker-Sort als {@link AbstractSorter}.
 * 
 */
public class ShakerSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {
    // TODO: Implementierung von ShakerSort
    //initialisierung der notwendigen parameter
    boolean swapped = true;
    int start = 0;
    int end = input.length();

    while(swapped == true){
      //swapped = false da noch nicht geswapped wurde
      swapped = false;
      //durchlauf des array von start bist ende t = O(n)
      for (int i = start; i < end-1; ++i) {
      //wurde eine stelle gefunden wo geswapped werden muss dann swap und setze swap auf true
        if (input.get(i).greaterThan(input.get(i + 1))) {
          input.swap(i + 1, i);
          swapped = true;
        }
      }
      //wenn nach der ersten for schleife nicht geswapped wurde, dann ist das array sortiert
      if(swapped == false){
        break;
      }
      // setze die swapped wieder auf false, damit man nicht aus der while loop fliegt
      swapped = false;
      //Ende ist immer sortiert und muss bis dahin nicht mehr durchlaufen werden
      end = end-1;
      //weitere for schleife diesmal von oben nach unten
      for (int i = end -1; i >= start; i--){
        if(input.get(i).greaterThan(input.get(i+1))){
          input.swap(i,i+1);
          swapped = true;
        }
      }
      //Anfang ist danach auch sortiert und sortierbereich kann verkleinert werden
      start = start+1;

    }
  }
}
