
//import java.util.Locale;

public class PalindromChecker {


  public static boolean isPalindromeIterative(String string) {
    // TODO: Sie dürfen eine Schleife, aber keine Rekursion verwenden!
    //Fall, wenn String leer ist
    if (string.isEmpty() == true) {
      return true;
    }
    //Erstelle cursor
    int i = 0;
    int j = string.length() - 1;
    //Vergleiche vorderer Character mit hinterem
    while (i < j) {
      if (Character.toLowerCase(string.charAt(i)) == (Character.toLowerCase(string.charAt(j)))) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    //ist die while durchgelaufen so war der String ein Palindrome
    return true;
  }


  public static boolean isPalindromeRecursive(String string) {
    // TODO: Sie dürfen eine Rekursion, aber keine Schleife verwenden!
    //Fall, wenn das substring in der String-Mitte angekommen ist und soweit ein Palindrome war,
    //Abbruchkriterium
    if (string.length() == 0 || string.length() == 1 || string.isEmpty()) {
      return true;
    }
    //if Schleife vergleicht vorderen und hinteren Character, wenn beide gleich sind,
    //erzeuge substring, ohne die verglichenen Character und Rekursiver Aufruf mit Übergabe des Substrings
    if (Character.toLowerCase(string.charAt(0)) == (Character.toLowerCase(string.charAt(string.length() - 1)))) {
      String smallerString = string.substring(1, string.length() - 1);
      return isPalindromeRecursive(smallerString);
    }
    //If schleife wurde verlassen, kein Palindrome
      return false;


  }
}
