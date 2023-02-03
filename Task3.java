import java.util.ArrayDeque;
import java.util.Scanner;

/**Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи.
 * Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
 * Например:
 * 5 4 3 − +       =>     5 1 +     =>      6
 */
public class Task3 {

    public static void main(String[] args) {
        String postfixString = getStringPostfixRecordByUser();
        System.out.println("Получена запись от пользователя: " + postfixString);
        calculatePostfix(postfixString);
    }

    private static String getStringPostfixRecordByUser() { //получение от пользователя постфиксной записи
        System.out.print("Введите числа и операции в посфиксной записи через пробел, например \"5 4 3 − +\": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static boolean isDigit(String s) throws NumberFormatException { // проверка, является ли извлекаемая строка
        try {                                                               // числом
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static void calculatePostfix(String postfixRecord) { //постфиксный калькулятор
        ArrayDeque<Double> stackCalculations = new ArrayDeque<>(); //мой стэк для вычислений, тип Double из-за операции деления
        String[] charData = postfixRecord.split(" "); //разбиваю строку в массив стрингов через пробел

        for (String element : charData) { //пробегаюсь по каждому элементу массива строк, состоящего из "чисел" и
            if (isDigit(element))        //"знаков операций вычисления", если строка является числом, то
                stackCalculations.add(Double.parseDouble(element)); // добавляем число в стэк, итак до тех пор крутимся,
            else { //пока условие true, иначе происходит "изьятие с удалением" двух последних элементов из стека, их
                switch (element) { // вычисление, добавление результата вычисления обратно в конец стэка
                    case "+":
                        double result = stackCalculations.removeLast() + stackCalculations.removeLast();
                        stackCalculations.addLast(result);
                        break;
                    case "-":
                        result = -stackCalculations.removeLast() + stackCalculations.removeLast();
                        stackCalculations.addLast(result);
                        break;
                    case "*":
                        result = stackCalculations.removeLast() * stackCalculations.removeLast();
                        stackCalculations.addLast(result);
                        break;
                    case "/":
                        double numberDivisor = stackCalculations.removeLast();
                        if(numberDivisor!=0) {
                            result = stackCalculations.removeLast() / numberDivisor;
                            stackCalculations.addLast(result);
                        } else throw new IllegalStateException ("Деление на \"0\" !!!"); //обработка ошибки
                        break;
                    default:
                        break;
                }
            }
        }
        if(stackCalculations.size() == 1) System.out.println("В СТЭКЕ ОСТАЛОСЬ ОДНО ЧИСЛО: " + stackCalculations +
                " - ЭТО РЕЗУЛЬТАТ ВЫЧИСЛЕНИЯ"); //проверка, в стэке должен остаться один элемент,
        else {                                  //он и будет являться результатом вычисления
            System.out.println("ПОЛЬЗОВАТЕЛЬ НЕККОРЕКТНО ВВЕЛ ДАННЫЕ ДЛЯ ВЫЧИСЛЕНИЯ"); //если больше 2 элементов,
        }                                                                             // выводим сообщение на экран
    }
}




