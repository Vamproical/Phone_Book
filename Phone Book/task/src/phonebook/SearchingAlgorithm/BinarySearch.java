package phonebook.SearchingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class BinarySearch {
    /*public static int binarySearch(List<RepresentPhoneBook> array, RepresentPhoneBook elem, int left, int right) {
        String elemFull = elem.getFirstName() + elem.getSecondName();
        int medium = left + (right - left) / 2;
        String arrayFull = array.get(medium).getFirstName() + array.get(medium).getSecondName();
        while (left <= right) {
            medium = left + (right - left) / 2;
            arrayFull = array.get(medium).getFirstName() + array.get(medium).getSecondName();
            int res = arrayFull.compareTo(elemFull);
            if (res == 0) {
                System.out.println(elemFull);
                System.out.println(arrayFull);
                return 1;
            }
            if (res > 0)
                left = medium + 1;

            else
                right = medium - 1;
        }
        if(!elemFull.equals(arrayFull)) {
            System.out.println(elemFull);
            System.out.println(arrayFull);
        }
        return 0;
    }*/

    public static int binarySearch(List<RepresentPhoneBook> array, RepresentPhoneBook elem) {
        int low = 0;
        int high = array.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = array.get(mid).getFirstName().compareTo(elem.getFirstName()) + array.get(mid).getSecondName().compareTo(elem.getSecondName());
            if (res < 0) {
                low = mid + 1;
            } else if (res > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
