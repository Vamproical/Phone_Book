package phonebook.SearchingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class LinearSearch {
    public static int linearSearch(List<RepresentPhoneBook> arrayWithData, List<RepresentPhoneBook> arrayWithDataForSearch) {
        int foundPos = 0;
        for (RepresentPhoneBook data : arrayWithData) {
            for (RepresentPhoneBook dataForSearch : arrayWithDataForSearch) {
                if (dataForSearch.equals(data)) {
                    data.setPhoneNumber(dataForSearch.getPhoneNumber());
                    foundPos++;
                    break;
                }
            }
        }
        return foundPos;
    }
}
