

//import sorting.framework.AbstractSorter;
//import sorting.framework.SortableArray;


public class QuickSorter extends AbstractSorter {

  @Override
  protected <T> void sort(SortableArray<T> input) {
    quickSortRekursiv(input, 0, input.length() - 1);
  }

  protected <T> void quickSortRekursiv(SortableArray<T> input, int von, int bis) {
    //wenn von und bis sich kreuzen dann wurde das array sortiert
    if(von < bis){
      //mache eine partition und returne nächsten pivotStelle
      int pivotIndex = partition(input,von, bis);

      //rekursiver Aufruf mit den nächsten pivotStellen
      quickSortRekursiv(input, von, pivotIndex-1);
      quickSortRekursiv(input, pivotIndex+1, bis);
    }
  }

  protected <T> int partition(SortableArray<T> input, int von, int bis) {
    //Wähle pivot aus
    int pivotIndex = (von + bis)/2;
    //speichere pivotElement
    SortableArray <T>.ArrayElement pivot = input.get(pivotIndex);
    //Setze pivot an erste Stelle
    input.swap(von,pivotIndex);
    //speichere Von und Bis Grenzwerte
    int vonCursor = von;
    int bisCursor = bis;
    //gehe von beiden Seiten durch und vergleiche Werte mit pivotElement
    while(vonCursor < bisCursor){
      //vergleiche Werte von links
      while(vonCursor < bis && input.get(vonCursor).lessOrEqual(pivot)){
        vonCursor++;
      }
      //vergleiche Werte von rechts
      while(bisCursor > von && input.get(bisCursor).greaterOrEqual(pivot)){
        bisCursor--;
      }
      //es wurden Werte gefunden die geswapt werden können
      if(vonCursor < bisCursor){
        input.swap(vonCursor,bisCursor);
      }
    }
    //setze das pivotElement an die richtigeStelle und return die nächste Position für das Pivot
    input.swap(von,bisCursor);
    return bisCursor;
  }
}
