package Zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Algorytm2Dsp2 {
    public static void main(String[] args) {

        int tab[][] = new int[0][];
        List<Punkt> punkty = new ArrayList<>();
        int liczbaOperacji = 0;
        String [] tym;
        Path path = Paths.get("szymonBartkowiakPS1.txt");
        int howManyPoint = 9;

        try {
            List<String> lines = Files.readAllLines(path);
            tab = new int[howManyPoint][2];
            int i = 0;
            for(String line : lines) {
                tym = line.split(" ");
                tab[i][0] = Integer.parseInt(tym[0]); //x
                tab[i][1] = Integer.parseInt(tym[1]); //y
                i++;
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new RuntimeException(e);
        }

        //Sortowanie po X i Y
        int[][] tabX = new  int[howManyPoint][2];
        for (int i = 0; i < howManyPoint; i++) {
            tabX[i] = Arrays.copyOf(tab[i], tab[i].length);
        }
        int[][] tabY = new  int[howManyPoint][2];
        for (int i = 0; i < howManyPoint; i++) {
            tabY[i] = Arrays.copyOf(tab[i], tab[i].length);
        }
        quicksort(tabX,0, tab.length - 1,0);
        quicksort(tabY,0, tab.length - 1,1);




    }
        private static void quicksort(int[][] array, int lowIndex, int highIndex,int place) {

            if (lowIndex >= highIndex) {
                return;
            }

            int pivot = array[highIndex][place];

            int leftPointer = partition(array, lowIndex, highIndex, pivot, place);

            quicksort(array, lowIndex, leftPointer - 1,place);
            quicksort(array, leftPointer + 1, highIndex,place);

        }

        private static int partition(int[][] array, int lowIndex, int highIndex, int pivot, int place) {
            int leftPointer = lowIndex;
            int rightPointer = highIndex - 1;

            while (leftPointer < rightPointer) {

                while (array[leftPointer][place] <= pivot && leftPointer < rightPointer) {
                    leftPointer++;
                }

                while (array[rightPointer][place] >= pivot && leftPointer < rightPointer) {
                    rightPointer--;
                }

                swap(array, leftPointer, rightPointer);
            }

            if(array[leftPointer][place] > array[highIndex][place]) {
                swap(array, leftPointer, highIndex);
            }
            else {
                leftPointer = highIndex;
            }

            return leftPointer;
        }

        private static void swap(int[][] array, int index1, int index2) {
            int place = 0;
            int temp = array[index1][place];
            array[index1][place] = array[index2][place];
            array[index2][place] = temp;
            swap(array,index1,index2,1);
        }
    private static void swap(int[][] array, int index1, int index2,int place) {
        int temp = array[index1][place];
        array[index1][place] = array[index2][place];
        array[index2][place] = temp;
    }
    private static void print(int[][] tab) {
        for (int[] ints : tab) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}


