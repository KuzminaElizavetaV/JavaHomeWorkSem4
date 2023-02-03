import java.util.ArrayList;
import java.util.Arrays;

/** 4. (Необязательная задача повышенной сложности)
 * Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
 * Разность:
 * A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
 * B - A = все числа из второй коллекции, которые не содержатся в первой
 * Симметрическая разность:
 * A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 * */

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListA = new ArrayList<>(Arrays.asList(1, 3, 7, 4, 12, 5, 9, 25, 60, 8, 100));
        ArrayList<Integer> arrayListB = new ArrayList<>(Arrays.asList(5, 2, 42, 99, 1, 4, 8, 11, 0, 35));
        arrayListDifference(arrayListA, arrayListB);
        arrayListDifferenceReverse(arrayListA, arrayListB);


    }
    private static void arrayListDifference(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        for (Integer number: arrayList2) {
            if(arrayList1.contains(number)) arrayList1.remove(number);
        }
        System.out.println(arrayList1);
    }
    private static void arrayListDifferenceReverse(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        for (Integer number: arrayList1) {
            if(arrayList2.contains(number)) arrayList2.remove(number);
        }
        System.out.println(arrayList2);
    }
}
