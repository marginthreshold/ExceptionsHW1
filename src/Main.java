import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        intDivision(100, 0);

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arrayElementDivideBy2(array, 14);

        File file = new File("text.txt");
        fileOpening(file);

        String[][] myStringArray = {
                {"1", "2", "3", "5", "10"},
                {"3", "2", "1", "5", "10"},
                {"111", "222", "333", "7", "10"}
        };

        System.out.println(sum2d(myStringArray));

        int[] array1 = new int[]{10,10,10,10};
        int[] array2 = new int[]{2,2,2,2,2};
        printArray(arrIndexDivideByArrIndex(array1,array2));
    }

    public static void intDivision(int dividend, int divisor) {
        try {
            int result = dividend / divisor;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Делить на 0 нельзя");
        }

    }

    public static void arrayElementDivideBy2(int[] array, int index) {
        try {
            int result = array[index] / 2;
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Такого индекса в массиве не существует");
        }
    }

    public static void fileOpening(File file) {
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) { // если в массиве столбцов меньше 5 , надо отлавливать ArrayIndexOutOfBoundsException
                int val = Integer.parseInt(arr[i][j]); // если значения не числа в тексте, надо отлавливать NumberFormatException
                sum += val;
            }
        }
        return sum;
    }

    public static int[] arrIndexDivideByArrIndex(int[] arrayDivided, int[] arrayDivisor) {
        int min = min(arrayDivided.length, arrayDivisor.length);
        int[] newArray= new int[min];
        if (arrayDivided.length != arrayDivisor.length) throw new RuntimeException("Длины массивов отличаются");
        for (int i = 0; i < min; i++) {
            newArray[i]=arrayDivided[i]/arrayDivisor[i];
        }
        return newArray;
    }

    public static void printArray(int[] array){
        for (int i = 0;  i< array.length; i++) {
            System.out.print(i+",");
        }
    }

}