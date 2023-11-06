import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        int [] tab = new int [100_000_00];
        Random random = new Random();
        for(int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(100000)+1;
        }
        String result = Arrays.stream(tab)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);

        quicksort(tab);

        result = Arrays.stream(tab)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
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
