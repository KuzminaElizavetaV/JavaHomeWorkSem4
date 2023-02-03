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
        System.out.println("КОЛЛЕКЦИЯ ЧИСЕЛ (A): "+ arrayListA);
        System.out.println("КОЛЛЕКЦИЯ ЧИСЕЛ (B): "+ arrayListB);
        collectionDifference(arrayListA, arrayListB);
        collectionDifferenceReverse(arrayListA, arrayListB);
        symmetricCollectionDifference(arrayListA, arrayListB);
    }
    private static void collectionDifference(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        ArrayList<Integer> listDiff1 = new ArrayList<>(arrayList1); // создаю копию коллекции A, чтобы вносить изменения
        for (Integer numList2: arrayList2) { //цикл по коллекции В
            if(listDiff1.contains(numList2)) //если коллекция А (копия) содержит элемент коллекции В, то
                listDiff1.remove(numList2); //удаляем этот элемент из коллекции А (нашей рабочей копии)
            else return;
        }
        System.out.println("РАЗНОСТЬ (A - B): " + listDiff1);
    }
    private static void collectionDifferenceReverse(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        ArrayList<Integer> listDiff2 = new ArrayList<>(arrayList2); // создаю копию коллекции B, чтобы вносить изменения
        for (Integer numList1: arrayList1) { //сделано по аналогии с предыдущим методом, только все зеркально
            if(listDiff2.contains(numList1))
                listDiff2.remove(numList1);
            else return;
        }
        System.out.println("РАЗНОСТЬ (B - A): "+ listDiff2);
    }
    private static void symmetricCollectionDifference(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2){
        ArrayList<Integer> listSymDiff = new ArrayList<>(arrayList1); // создаю копию коллекции A
        for (Integer numList2: arrayList2) {// числа из первой коллекции, которых нет во второй, т.е. (А - В)
            if(listSymDiff.contains(numList2)) listSymDiff.remove(numList2); //А ТАКЖЕ числа из второй, которых нет в первой
            else listSymDiff.add(numList2); //добавляю в результирующий ArrayList (listSymDiff)
        }
        System.out.println("СИМЕТРИЧЕСКАЯ РАЗНОСТЬ (A ^ B):\n" + listSymDiff);
    }
}
