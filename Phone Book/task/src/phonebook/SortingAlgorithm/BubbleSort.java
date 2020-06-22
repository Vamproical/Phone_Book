package phonebook.SortingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class BubbleSort {
    public static boolean bubbleSort(List<RepresentPhoneBook> arrayWithData, long maxDuration) {
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < arrayWithData.size() - 1; j++) {
            for (int i = j + 1; i < arrayWithData.size(); i++) {
                if (arrayWithData.get(j).getFirstName().compareTo(arrayWithData.get(i).getFirstName()) > 0) {
                    RepresentPhoneBook temp = arrayWithData.get(j);
                    arrayWithData.set(j, arrayWithData.get(i));
                    arrayWithData.set(i, temp);
                }
                if (System.currentTimeMillis() - startTime > maxDuration) {
                    return true;
                }
            }
        }
        return false;
    }
}
