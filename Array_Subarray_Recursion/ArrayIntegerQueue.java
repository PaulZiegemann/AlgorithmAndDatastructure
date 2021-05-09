

//import java.util.NoSuchElementException;

public class ArrayIntegerQueue implements IntegerQueue {

  // Verwenden Sie keine weiteren Instanzvariablen!
  private int[] array;
  private int first = 0;
  private int size = 0;

  // Dieser Konstruktor ist vollstaendig!
  public ArrayIntegerQueue(final int initialSize) {
    array = new int[initialSize];
  }

  @Override
  public void enqueue(final int element) {
    // TODO: Hinzufuegen implementieren, dabei beruecksichtigen,
    // bin ich nun beim Fall das mein array voll ist so muss ich das Array vergrößern,
    // zuerst muss geprüft werden, dass dies auch der Fall ist
    // mit der if Anweisung prüfe ich dies, wenn nun first an der Stelle 0 steht, so muss ich an der hintersten
    //Stelle im array nachschauen ob dort ein Wert steht, ansonsten kann ich einfach den Wert vor first anschauen
    //Denn bei first-1 ist ja das absolute Ende meine Warteschlange von der Größe her
    if( (first == 0 && array[array.length-1] != 0) || (first != 0 && array[first-1] != 0)){
      //ich erstelle ein neues array mit doppelter Größe
      int [] tmpArray = new int[array.length*2];
      //dieser boolean ist dazu da, falls ich einmal um das Array rum muss
      boolean hasCycled = false;
      // integer für die Stelle meines neuen Arrays
      int n = 0;
      for(int i = first; i < array.length; i++){
        //setze die Werte von first beginnenend in das neue array ein
        tmpArray[n++] = array[i];
        //diese if dient dazu, falls ich am ende der arrays angelangt bin aber noch nicht alle werte
        //übergeben habe, denn damit muss ich von 0 bis first-1 noch die weiteren Werte ins neue Array schreiben
        if(i == array.length-1 && first != 0){
          i = -1;
          hasCycled = true;
        }
        //bin ich nun um die komplette Warteschlange rum, so setze ich first auf 0 weil, ja der Anfang der Warteschlange
        // an der Stelle 0 beginnt und verlasse die for-schleife
        if(i == first-1 && hasCycled == true && first != 0){
          first = 0;
          break;
        }
      }
      //nun ersetze ich das alte mit dem neuen array
      array = tmpArray;
    }

    //Ist das array nicht voll so speicher den Wert ans Ende der Warteschlange
    //Dabei muss geachtet werden wo das Ende der Warteschlange ist, da die Warteschlange zyklisch
    // von vorne anfängt wenn Plätze frei sind muss darauf geachtet werden
    // Dies tu ich mit einer if, wenn der Anfang der Warteschlange + die Größe der Warteschlange
    // meine Größe des Arrays übertrifft so muss ich vom Anfang weiter gehen, deswegen subtrahiere ich
    // die arraylänge
    if(first+size > array.length-1){
      array[(first+size) - (array.length)] = element;
    }else {
      //wenn der Anfang der Warteschlange + die Größe der Warteschlange, nicht größer ist als mein Array,
      //so kann ich ihn an die jeweilige Stelle setzen
      array[first + size] = element;
    }
    size++;
  }


  @Override
  public int head() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    // TODO: Rueckgabe des vordersten Elements implementieren
    //hier soll der Wert der an erster Stelle steht in der Warteschlange zurückgegeben
    return array[first];
  }

  @Override
  public int dequeue() {
    if (size == 0) {
      throw new NoSuchElementException();
    }

    // TODO: Entfernen implementieren - das Array muss nicht schrumpfen!
    //hier soll der Wert, der an erster Stelle in der Warteschlange steht, zurückgegeben und
    //aus der Warteschalnge entnommen werden, die Stelle im Array soll wieder auf 0 gesetzt werden, aber die Stelle
    //first wird um 1 erhöht somit steht der nächste Wert als erstes in der Warteschlange
    // bin ich mit first an der Grenze des Arrays angekommen so resete ich first wieder auf 0
    // ob nun dort noch ein Wert steht oder nicht ist dabei egal, da wenn einer steht ich diesen dann wieder ausgebe
    // und wenn dort keiner steht hat sich das komplette array wieder resetet
    int tmpFirst = first;
    if(first+1 == array.length){
      first = 0;
    }else{
      first++;
    }
    //die Größe der Warteschlange wird um 1 kleiner da der Wert aus der Queue entnommen wurde
    size--;
    int tmp = array[tmpFirst];
    array[tmpFirst] = 0;
    return tmp;
  }

  @Override
  // Implementierung vollstaendig!
  public int size() {
    return size;
  }

  @Override
  // Implementierung vollstaendig!
  public boolean isEmpty() {
    return size == 0;
  }
}
