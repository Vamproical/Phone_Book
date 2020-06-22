package phonebook.SortingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class BubbleSort {
    public static List<RepresentPhoneBook> bubbleSort(List<RepresentPhoneBook> arrayWithData) {
        for (int i = 0; i < arrayWithData.size() - 1; i++) {
            for (int j = 0; j < arrayWithData.size() - i - 1; j++) {
                if (arrayWithData.get(j).getFirstName().compareTo(arrayWithData.get(j + 1).getFirstName()) >= 0) {
                    RepresentPhoneBook temp = arrayWithData.get(j);
                    arrayWithData.set(j,arrayWithData.get(j + 1));
                    arrayWithData.set(j + 1,temp);
                }
            }
        }

        return arrayWithData;
    }
}
