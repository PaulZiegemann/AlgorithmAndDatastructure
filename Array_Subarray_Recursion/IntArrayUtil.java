
/**
 * Hilfsklasse mit Berechnungsmethoden für Arrays von Ganzzzahlen.
 */
public class IntArrayUtil {

  /**
   * Ermittelt die Anzahl von Elementen eines Arrays (Input), die nicht in einem anderen Array
   * (Filter) vorkommen. Dabei dürfen beide Arrays doppelte Zahlen enthalten und unsortiert sein.
   * Laufzeit in O(n^2).
   * Beispiel: Ist input = {6,2,6,1,7,2,1,4} und filter = {6,3,8,4,4,9,3}, werden die Elemente
   * {2,1,7,2,1} gezählt, das Ergebnis ist also 5.
   *
   * @param input  Array aus zu zählenden Werten
   * @param filter Array auszufilternder Werte
   * @return Anzahl der Zahlen in input die nicht in filter vorkommen. Doppelte Zahlen in
   * input werden dabei alle gezählt.
   */
  public static int filterCountUnsorted(final int[] input, final int[] filter) {
    //Erstelle result als Länge des inpunt arrays,
    //man geht davon aus das alle Werte erstmal nicht im Filterarray vertreten sind
    int result = input.length;

    // TODO: Implementierung ergänzen.
    // Erste for Schleife für die Werte des input arrays
    for(int i = 0; i < input.length; i++){
      //jeder Werte des input arrays wird mit jedem Wert des filterarrays verglichen
      for(int j = 0; j < filter.length; j++){
        // wenn Werte übereinstimmen muss der result um 1 subtrahiert werden
        if(input[i] == filter[j]){
          result--;
          break;
        }
      }
    }
    //result hat nun die Anzahl an Werten die nicht mit dem Filter übereinstimmen
    //mit zwei geschachtelten for-schleifen kommt man auf eine Laufzeit von n*n
    return result;
  }

  /**
   * Ermittelt die Anzahl von Elementen eines Arrays (Input), die nicht in einem anderen Array
   * (Filter) vorkommen. Dabei dürfen beide Arrays doppelte Werte enthalten, aber nur
   * Input darf unsortiert sein. Die Werte in Filter müssen aufsteigend sortiert sein.
   * Laufzeit in O(n log n).
   * Beispiel: Ist input = {6,2,6,1,7,2,1,4} und filter = {3,3,4,4,6,8,9}, werden die Elemente
   * {2,1,7,2,1} gezählt, das Ergebnis ist also 5.
   *
   * @param input  Array aus zu zählenden Werten
   * @param filter Array auszufilternder Werte
   * @return Anzahl der Zahlen in input die nicht in filter vorkommen. Doppelte Zahlen in
   * input werden dabei alle gezählt.
   */
  public static int filterCountFilterSorted(final int[] input, final int[] filter) {
    int result = input.length;
    // TODO: Implementierung ergänzen, Voraussetzungen müssen nicht geprüft werden!
    // Tipp: Verwenden Sie die untenstehende Implementierung der Binären Suche aus der Vorlesung.
    //for Schleife für die Inputwerte
    for(int i = 0; i < input.length; i++){
      //mit binarySearche liegt ein sortiertes filterarray vor,
      //nun wird geschaut ob der jeweilige input wert größer oder kleiner des mittleren filterwertes ist
      //so grenzt man viel schneller den Bereicht ein, wo der Wert liegen würde und kommt damit auf eine
      //Laufzeit von log(n)
      //mit der for-schleife und einem binarysearche kommt man auf eine Laufzeit von n*log(n)
      if(binarySearch(filter,input[i]) == true){
        result --;
      }
    }
    return result;
  }

  /**
   * Implementierung der Binären Suche aus der Vorlesung. Sucht ein Element in einer sortierten
   * Liste von Ganzzahlen.
   *
   * @param sorted  Array von Ganzzahlen, aufsteigend sortiert
   * @param element zu suchendes Element
   * @return {@code true} genau dann, wenn das gesuchte Element im Array vorkommt.
   */
  @SuppressWarnings("unused")
  private static boolean binarySearch(final int[] sorted, final int element) {
    int lo = 0;
    int hi = sorted.length - 1;
    while (lo <= hi) {
      int m = (lo + hi) / 2;
      if (sorted[m] == element) {
        return true;
      }
      if (sorted[m] > element) {
        hi = m - 1;
      }
      if (sorted[m] < element) {
        lo = m + 1;
      }
    }
    return false;
  }

  /**
   * Ermittelt die Anzahl von Elementen eines Arrays (Input), die nicht in einem anderen Array
   * (Filter) vorkommen. Dabei dürfen beide Arrays doppelte Werte enthalten, müssen aber aufsteigend
   * sortiert sein. Laufzeit in O(n).
   * Beispiel: Ist input = {1,1,2,2,4,6,6,7} und filter = {3,3,4,4,6,8,9}, werden die Elemente
   * {1,1,2,2,7} gezählt, das Ergebnis ist also 5.
   *
   * @param input  Array aus zu zählenden Werten
   * @param filter Array auszufilternder Werte
   * @return Anzahl der Zahlen in input die nicht in filter vorkommen. Doppelte Zahlen in
   * input werden dabei alle gezählt.
   */
  public static int filterCountSorted(final int[] input, final int[] filter) {
    int result = input.length;
    int i = 0;
    int j = 0;
    // TODO: Implementierung ergänzen, Voraussetzungen müssen nicht geprüft werden!
    // da nun zwei sortierte Arrays vorliegen, kann man nun die laufzeit auf n kürzen
    //Dabei wird eine while-schleife verwendet, solange i nicht am Ende des Arrays ankommt so,
    while(i < input.length && j < filter.length) {

    //stimmen die Werte überein so subtrahiere den result und addiere i um 1
      if(input[i] == filter[j]){
        result--;
        i++;
      }

    //wenn inputWert kleiner ist als der filter Wert, so erhöhe i um 1
      else if(input[i] < filter[j]){
        i++;
      }

    //sonst ist der filterWert kleiner, also muss j um 1 addiert werden
      else {
        j++;
      }
    }
      return result;
    }

  }

