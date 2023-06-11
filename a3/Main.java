import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

class NumberValidationException extends Exception {
    public NumberValidationException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new LinkedList<>();

        try {
            addToList(list1, "10");
            addToList(list1, "20");

            addToList(list2, "30");
            addToList(list2, "40");

            addToList(list3, "50");
            addToList(list3, "60");

            list1.addAll(list2);
            list1.addAll(list3);

            System.out.println("Verificando se um elemento da lista 2 está na lista 1:");
            System.out.println(list1.containsAll(list2));

            System.out.println("Verificando se todos os elementos da lista 3 estão na lista 1:");
            System.out.println(list1.containsAll(list3));

            System.out.println("Verificando se a lista 1 é igual à lista 2:");
            System.out.println(list1.equals(list2));

            System.out.println("Elemento 2 de cada lista:");
            System.out.println(list1.get(1));
            System.out.println(list2.get(1));
            System.out.println(list3.get(1));

            System.out.println("Removendo um elemento da lista 3:");
            list3.remove(0);

            System.out.println("Removendo os elementos da lista 3 da lista 1:");
            list1.removeAll(list3);

            System.out.println("Tamanho da lista 1: " + list1.size());

            System.out.println("Limpando a lista 3:");
            list3.clear();

            System.out.println("Verificando se a lista 3 está vazia:");
            System.out.println(list3.isEmpty());

            System.out.println("Elementos da lista 1:");
            for (String element : list1) {
                System.out.println(element);
            }
        } catch (NumberValidationException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void addToList(List<String> list, String element) throws NumberValidationException {
        if (containsNumber(element)) {
            list.add(element);
        } else {
            throw new NumberValidationException("O texto digitado não contém um número válido: " + element);
        }
    }

    public static boolean containsNumber(String text) {
        return text.matches(".*\\d.*");
    }
}
