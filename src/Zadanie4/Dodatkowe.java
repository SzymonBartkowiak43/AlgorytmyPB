package Zadanie4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Dodatkowe {
    public static void main(String[] args) {
        Path path = Paths.get("src/Zadanie4/DodatkoweZad.txt");
        int tab[];
        int secondTab[];
        int size;
        try {
            int licznik = 0;
            List<String> lines = Files.readAllLines(path);
            size = Integer.parseInt(lines.get(0));
            tab = new int[size];
            secondTab = new int[size];
            lines.remove(0);
            for(String line: lines) {
                tab[licznik] = Integer.parseInt(line);
                licznik++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quicksort(tab);

        for(int i = 0; i < size;i++){
            secondTab[i] = 0;
        }


        int counterTab = 0;
        int counterSecondTab = 0;
        int wynik = 0;
        for(int i = 0;i < size;i++) {
            int firstElemnt;
            int secondElemnt;
            if(counterTab >= size) {
                break;
            }
            
            if(tab[counterTab] > secondTab[counterSecondTab]) {
                firstElemnt = tab[counterTab];
                counterTab++;
            } else {
                firstElemnt = secondTab[counterSecondTab];
                counterSecondTab++;
            }

            if(tab[counterTab] > secondTab[counterSecondTab]) {
                secondElemnt = tab[counterTab];
                counterTab++;
            } else {
                secondElemnt = secondTab[counterSecondTab];
                counterSecondTab++;
            }
            secondTab[counterSecondTab] = firstElemnt+secondElemnt;

            wynik += firstElemnt + secondElemnt;
        }
        System.out.println(wynik);



    }
    private static void quicksort(int[] array) {
        quicksort(array,0,array.length -1);
    }
    private static void quicksort(int[] array, int lowIndex, int highIndex)  {

        if(lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex-lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex,highIndex);

        int leftPointer = partition(array,lowIndex,highIndex,pivot);


        quicksort(array,lowIndex,leftPointer-1);
        quicksort(array,leftPointer +1,highIndex);

    }

    private static void swap(int[] array, int index1,int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static  int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,highIndex);
        return leftPointer;
    }
}
