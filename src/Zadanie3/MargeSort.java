package Zadanie3;

import java.util.Random;

public class MargeSort {
    public void mergeSort(int[][] array, int lowIndex, int highIndex, int place) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = array[highIndex][place];

        int leftPointer = partition(array, lowIndex, highIndex, pivot, place);

        mergeSort(array, lowIndex, leftPointer - 1, place);
        mergeSort(array, leftPointer + 1, highIndex, place);

    }

    private  int partition(int[][] array, int lowIndex, int highIndex, int pivot, int place) {
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

        if (array[leftPointer][place] > array[highIndex][place]) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;

    }

    private void swap(int[][] array, int index1, int index2) {
        int place = 0;
        int temp = array[index1][place];
        array[index1][place] = array[index2][place];
        array[index2][place] = temp;
        swap(array, index1, index2,1);
    }
    private  void swap(int[][] array, int index1, int index2, int place) {
        int temp = array[index1][place];
        array[index1][place] = array[index2][place];
        array[index2][place] = temp;
    }
    public void print(int[][] tab) {
        for (int[] ints : tab) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
