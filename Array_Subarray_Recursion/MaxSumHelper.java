
public class MaxSumHelper {

  protected static final int[] WEEKENDS = {20, 18, 26, 16, 7, 6, 18, 21, 17, 14, 13, 21, 17, 18, 5,
          25, 28, 20, 9, 22, 28, 29, 15, 28, 10, 8, 6, 21, 5, 11, 28, 16, 5, 22, 21, 5, 12, 25, 27, 22,
          20, 11, 16, 15, 11, 24, 22, 18, 29, 13, 15, 23};

  protected static final int[] DEMO = {2, 4, 1, 1, 5, 6, 2};

  public static void main(String[] args) {
    // System.out.println(maxSumWithGapRecursive(WEEKENDS, 3));
    // System.out.println(maxSumWithGapDynamic(WEEKENDS, 3));
    // System.out.println(maxSumWithGapRecursive(DEMO, 3));
    // System.out.println(maxSumWithGapDynamic(DEMO, 3));
  }

  public static int maxSumWithGapRecursive(int[] array, int gap) {
    if (array.length == 0) {
      return 0;
    }
    return maxSumWithGapRecursive(array, gap, array.length - 1);
  }

  private static int maxSumWithGapRecursive(int[] array, int gap, int index) {

    //Fall für index = 0, wir sind am Ende des Arrays angekommen, somit Abbruch
    if (index <= 0) {
      return array[0];
    }
    //Letzte Auswahl des Sonntags, da hier Auswahlmöglichkeit besteht, sollte der beste Sonntag gewählt werden
    //Nochmals wird hier der jetzige Wert mit der nächsten Rekursion verglichen, bei erneutem Rekursionsstart
    //Fällt man wieder in diese if-Schleife, da index <= gap, somit wird wieder verglichen, bis zum index = 0, beim Abbruch
    //All diese Werte werden verglichen und der beste Wert wird returned, dieser wird dann zum vorherigen Wert (Line 64)
    //angehängt
    if (index <= gap) {
      int val = array[index];
      int nextVal = maxSumWithGapRecursive(array, gap, index - 1);
      if (val > nextVal) {
        return val;
      } else {
        return nextVal;
      }
    }
    //Fall, wenn Index größer Gap ist, also noch die besten Werte sucht
    if (index > gap) {
      //Starte an der ersten Arraystelle und starte Rekursionen an der nächsten Stellen
      //Vergleiche jeweils die Summen der anderen Rekursionen und wähle die maximale Summe
      //val entspricht der jetzigen Summe + den Nachfolgern, nextVal ist der Start einer neuen Rekursion beim nächsten Wert
      //Wenn der Anfangsstart nicht optimal war, wird irgenwann eine Summe einer Rekursion, an einem besserem Startpunkt überwiegen und
      //die Summe dieser returned.
      int val = array[index] + maxSumWithGapRecursive(array, gap, index - gap - 1);
      int nextVal = maxSumWithGapRecursive(array, gap, index - 1);

      if (val > nextVal) {
        return val;
      } else {
        return nextVal;
      }
    }
    return 0;
  }

  public static int maxSumWithGapDynamic(int[] array, int gap) {
    if (array.length == 0) {
      return 0;
    }
    int n = array.length;
    int[] optimumSum = new int[n];


    //Jetziger Lauf startet am Anfang des Array und zählt hoch
    //For-schleife durchlauf ganzes array
      for (int i = 0; i < n; i++) {
        //Erster Fall braucht ein continue, sonst läuft er in die nächste if
        //und es gibt eine OutOfBoundException
        //man speichert den Anfangswert in optimumsum
        if (i <= 0) {
          optimumSum[0] = array[0];
          continue;
        }
        //Wie gehabt im Rekursiven Beispiel nur anstatt return, speichert man die Werte in OptimalSum
        //vergleich der besten Wahl für den nächsten Sonntag
        if (i <= gap) {
          int val = array[i];
          int nextVal = optimumSum[i - 1];
          if (val > nextVal) {
            optimumSum[i] =  val;
          } else {
            optimumSum[i] = nextVal;
          }
        }
        //Wie in der Rekursion nur anstatt Rekursions aufruf und return speichert man den Wert in optimalSum
        if(i > gap) {
          int val = array[i] + optimumSum[i - gap - 1];
          int nextVal = optimumSum[i - 1];
          if (val > nextVal) {
            optimumSum[i] = val;
          } else {
            optimumSum[i] = nextVal;
          }
        }
        }

      //returne die optimale Summe
      return optimumSum[n-1];

  }
}