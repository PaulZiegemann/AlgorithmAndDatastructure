

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Klasse zur Erkennung von Klammergebirgen.
 */
public class Klammergebirge {

  public static boolean checkParentheses(final String string) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char par : string.toCharArray()) {
      // TODO: erkenne gueltige Klammerung in einem Durchlauf!

      // Offene Klammern sollen in den Stack an die erste Stelle gestzt werden
      if(par == '(' || par == '['){
        stack.addFirst(par);
      }

      // Kommt eine schließende Klammer
      if(par == ')' || par == ']') {

        // Der Stack darf nicht leer sein sonst kann man nicht die Methode getFirst benutzen
        if (stack.isEmpty() == false) {

          // liegt an der ersten Stelle die zugehörige Klammer, so entferne diese aus dem Stack
          if((stack.getFirst() == '(' && par == ')') || (stack.getFirst() == '[' && par == ']'))
          stack.removeFirst();
        }else{

          // sonst gibt es kein Klammernpaar und das Muster ist falsch
          // lade die Klammer ins Stack und verlasse die for-Schleife
          // die Klammer wird in das Stack geladen für den Fall, dass
          // es nur schließende Klammern im String sind
          stack.addFirst(par);
          break;
        }
      }
    }

    // ist der Stack nicht leer so gab es Klamemrn die nicht geschlossen wurden und somit
    // muss false returned werden
    if(stack.isEmpty() == false) {
      return false;
    }

    // der Stack ist leer und somit wurden alle Klammern geschlossen oder der String war von Anfang an leer
    return true;
  }
}