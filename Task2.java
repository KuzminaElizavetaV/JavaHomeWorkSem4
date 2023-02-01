import java.util.Arrays;
import java.util.LinkedList;

/**Реализуйте очередь с помощью LinkedList со следующими методами:
 * enqueue() - помещает элемент в конец очереди;
 * dequeue() - возвращает первый элемент из очереди и удаляет его;
 * first() - возвращает первый элемент из очереди, не удаляя.
 */
 public class Task2 {
    public static void main(String[] args) {
        LinkedList<Object> objectLinkedList = new LinkedList<>(Arrays.asList(1, 2, "три", "четыре", 5, 6, 7, "восемь"));
        System.out.println("Первоначальная очередь выглядит так: " + objectLinkedList);
        enqueue(objectLinkedList, 9);
        enqueue(objectLinkedList, "десять");
        dequeue(objectLinkedList);
        System.out.println("Очередь после удаления: " + objectLinkedList);
        first(objectLinkedList);
    }
    private static void enqueue(LinkedList<Object> linkedList, Object element) { //помещает элемент в конец очереди
        linkedList.addLast(element);
        System.out.println("Добавлен элемент \"" + element + "\" в конец очереди: " + linkedList);
    }
    private static void dequeue(LinkedList<Object> linkedList) { //возвращает первый элемент из очереди и удаляет его
        if (!linkedList.isEmpty()) {
            System.out.println("Удален первый элемент \"" + linkedList.getFirst() + "\"  из очереди.");
            linkedList.removeFirst();
        }
    }
    private static void first(LinkedList<Object> linkedList) { //возвращает первый элемент из очереди, не удаляя
        if (!linkedList.isEmpty()) System.out.println("Первый элемент очереди: "+ (linkedList.getFirst()));
    }
}

