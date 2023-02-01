import java.util.Arrays;
import java.util.LinkedList;
/**
 * Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернет “перевернутый” список.
 */
public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> listNumbers = new LinkedList<>(Arrays.asList(12, 15, 1, 6, 10, 123, 34, 56, 25, 67, 302));
        System.out.println("НАЧАЛЬНЫЙ СПИСОК ЧИСЕЛ: " + listNumbers);
        reverseList(listNumbers);
    }
    private static void reverseList(LinkedList<Integer> linkedList){
        for (int i = 0, j=linkedList.size() - 1; i < linkedList.size()/2; i++, j--) {
            int temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(j));
            linkedList.set(j, temp);
        }
        System.out.println("\"ПЕРЕВЕРНУТЫЙ\" СПИСОК:  " + linkedList);
    }
}
