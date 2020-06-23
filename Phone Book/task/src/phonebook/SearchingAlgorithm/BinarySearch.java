package phonebook.SearchingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class BinarySearch {
    public static int binarySearch(List<RepresentPhoneBook> array, RepresentPhoneBook elem, int left, int right) {
        String elemFull = elem.getFirstName() + elem.getSecondName();
        while (left <= right) {
            int medium = left + (right - left) / 2;
            String arrayFull = array.get(medium).getFirstName() + array.get(medium).getSecondName();
            int res = elemFull.compareTo(arrayFull);
            if (res == 0) {
                return 1;
            }
            if (res > 0)
                left = medium + 1;

            else
                right = medium - 1;
        }
        return 0;
    }
}
