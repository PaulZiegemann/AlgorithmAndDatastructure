
/**
 * Beispielklasse zur Lösung einer Praktikumsaufgabe.
 */
public class Euklid {

  /**
   * Berechnet den ggT zweier natürlicher Zahlen.
   *
   * @param a erste Zahl (positiv)
   * @param b zweite Zahl (positiv)
   * @return größter gemeinsamer Teiler von a und b
   */
  public static int ggtEuklid(int a, int b) {
    if (a <= 0 || b <= 0) {
      throw new IllegalArgumentException("Parameter müssen strikt positiv sein!");
    }

    // TODO: ggT-Berechnung mit euklidischem Algorithmus implementieren!
    if(a == 0 ) {
      // Wenn a = 0 returne b, dann hat man den ggT gefunden
      return b;
    } else {
      //
      while(b != 0) {
        if(a > b) {
          a = a -b;
        }else {
          b = b -a;
        }
      }
    }
    return a;
  }
}
