package Zadanie4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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


        Arrays.fill(secondTab, 0, size, 0);

        int counterTab = 0;
        int counterSecondTab = 0;
        int wynik = 0;
        int firstElemnt;
        int secondElemnt;
        for (int i = 0; i < size - 1; i++) {


            if(secondTab[counterSecondTab]  == 0) {
                firstElemnt = tab[counterTab++];
            } else {
                firstElemnt = (tab[counterTab] < secondTab[counterSecondTab]) ? tab[counterTab++] : secondTab[counterSecondTab++];
            }
            if(secondTab[counterSecondTab]  == 0) {
                secondElemnt = tab[counterTab++];
            } else {
                secondElemnt = (tab[counterTab] < secondTab[counterSecondTab]) ? tab[counterTab++] : secondTab[counterSecondTab++];
            }

            secondTab[counterSecondTab] = firstElemnt + secondElemnt;
            System.out.println("Pierwszy: " + firstElemnt + "Drugi: " + secondElemnt);
            wynik += firstElemnt + secondElemnt;
            System.out.println(wynik);
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
