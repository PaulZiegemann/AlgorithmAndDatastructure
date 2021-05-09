
/**
 * Hilfsklasse für Optimierungen auf Arrays.
 */
public class MaxSubArray {

  /**
   * Ermittelt die maximale Summe eines zusammenhängenden Teilarrays.
   *
   * @param values Eingabearray
   * @return Summe des optimalen Teilarrays
   */
  public static int maximumSubarray(final int[] values) {
    int m = -100;
    int n = 0;

    if(values.length == 0){
      return n;
    }

    for (int i = 0; i < values.length; i++){
      //summiere jetzigen Lauf auf
      n = n + values[i];

      //ist jetziger Lauf besser als vorheriger Lauf, speichere jetzigen Lauf in m
      if(m < n) {
        m = n;
      }

      //ist jetziger Lauf negative dann resete n auf 0, da es keinen positiven Gewinn mehr gibt
      if (n < 0) {
        n = 0;

      }

    }

    // ist das Array immer negativ so gebe 0 zurück
    if(m < 0){
      return 0;
    }

    // returne den besten Lauf als Summe
    return m;
  }
}