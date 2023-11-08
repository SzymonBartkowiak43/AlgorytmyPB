package Zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Algorytm2Dsp2 {
    public static void main(String[] args) {
        int maxValue = 10;
        int howManyPoint = 9;
        int tab[][] = new int[0][];
        int liczbaOperacji = 0;
        String [] tym;
        Path path = Paths.get("szymonBartkowiakPS1.txt");


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
        int[][] tabX = new int[howManyPoint][2];
        coping(tabX,tab,howManyPoint);

        int[][] tabY = new  int[howManyPoint][2];
        coping(tabY,tab,howManyPoint);

        quicksort(tabX,0, tab.length - 1,0);
        quicksort(tabY,0, tab.length - 1,1);

        //Prosta l dzialeaca Pl i Pr
        int[][] tabPlTym = new int[howManyPoint][2];
        int[][] tabPrTym = new int[howManyPoint][2];
        int sizePl = 0;
        int sizePr = 0;

        for(int i = 0; i < howManyPoint;i++) {
            if(tab[i][0] <= maxValue/2) {
                tabPlTym[sizePl][0] = tab[i][0];
                tabPlTym[sizePl][1] = tab[i][1];
                sizePl++;
            }
            if(tab[i][0] >= maxValue/2) {
                tabPrTym[sizePr][0] = tab[i][0];
                tabPrTym[sizePr][1] = tab[i][1];
                sizePr++;
            }
        }
        int[][] tabPl = shortTab(tabPlTym, sizePl);
        int[][] tabPr = shortTab(tabPrTym, sizePr);

        // to samo robie dla X i Y
        int[][] tabXl = new int[sizePl][2];
        int[][] tabXr = new int[sizePr][2];
        int[][] tabYl = new int[sizePl][2];
        int[][] tabYr = new int[sizePr][2];

        coping(tabXl,tabPl,sizePl);
        coping(tabXr,tabPr,sizePr);
        coping(tabYl,tabPl,sizePl);
        coping(tabYl,tabPr,sizePr);

        quicksort(tabXl,0, sizePl - 1,0);
        quicksort(tabXr,0, sizePr - 1,0);
        quicksort(tabYl,0, sizePl - 1,1);
        quicksort(tabYr,0, sizePr - 1,1);

    }
        private static void coping(int[][] tabK,int tab[][], int howManyPoint) {
            for (int i = 0; i < howManyPoint; i++) {
                tabK[i] = Arrays.copyOf(tab[i], tab[i].length);
            }
        }
        public static int[][] shortTab(int[][] oldTab, int newSize) {
            int[][] returnTab = new int[newSize][oldTab[0].length];

            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < oldTab[0].length; j++) {
                    returnTab[i][j] = oldTab[i][j];
                }
            }
        return returnTab;
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


