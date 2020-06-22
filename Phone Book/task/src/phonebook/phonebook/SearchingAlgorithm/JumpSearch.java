package phonebook.SearchingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class JumpSearch {
    /*public static int jumpSearch(RepresentPhoneBook arrayWithData, List<RepresentPhoneBook> arrayWithDataForSearch) {
        int foundPos = 0;
        int currentRight = 0;
        int prevRight = 0;

        if (arrayWithDataForSearch.size() == 0) {
            return -1;
        }

        if (array[currentRight] == target) {
            return 0;
        }

        int jumpLength = (int) Math.sqrt(array.length);

        while (currentRight < array.length - 1) {

            currentRight = Math.min(array.length - 1, currentRight + jumpLength);

            if (array[currentRight] >= target) {
                break;
            }

            prevRight = currentRight;
        }

        if ((currentRight == array.length - 1) && target > array[currentRight]) {
            return -1;
        }

        return backwardSearch(array, target, prevRight, currentRight) + foundPos;
    }*/

    public static int backwardSearch(int[] array, int target, int leftExcl, int rightIncl) {
        int count = 0;
        for (int i = rightIncl; i > leftExcl; i--) {
            ++count;
            if (array[i] == target) {
                return count;
            }
        }
        return -1;
    }
}
