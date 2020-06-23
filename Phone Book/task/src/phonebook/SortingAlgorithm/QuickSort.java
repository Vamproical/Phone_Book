package phonebook.SortingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class QuickSort {
    public static void quickSort(List<RepresentPhoneBook> array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(List<RepresentPhoneBook> array, int left, int right) {
        String pivot = array.get(right).getFirstName();
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array.get(i).getFirstName().compareTo(pivot) <= 0) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(List<RepresentPhoneBook> array, int i, int j) {
        RepresentPhoneBook temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
