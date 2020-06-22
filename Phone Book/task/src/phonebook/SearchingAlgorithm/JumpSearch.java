package phonebook.SearchingAlgorithm;

import phonebook.RepresentPhoneBook;

import java.util.List;

public class JumpSearch {
    public static int jumpSearch(RepresentPhoneBook arrayWithData, List<RepresentPhoneBook> arrayWithDataForSearch) {
        int foundPos = 0;
        int currentRight = 0;
        int prevRight = 0;

        if (arrayWithDataForSearch.size() == 0) {
            return 0;
        }

        if (arrayWithDataForSearch.get(currentRight).getFirstName().equals(arrayWithData.getFirstName()) && arrayWithDataForSearch.get(currentRight).getSecondName().equals(arrayWithData.getSecondName())) {
            return 0;
        }

        int jumpLength = (int) Math.sqrt(arrayWithDataForSearch.size());

        while (currentRight < arrayWithDataForSearch.size() - 1) {

            currentRight = Math.min(arrayWithDataForSearch.size() - 1, currentRight + jumpLength);

            if (arrayWithDataForSearch.get(currentRight).getFirstName().compareTo(arrayWithData.getFirstName()) > 0 &&
                    arrayWithDataForSearch.get(currentRight).getSecondName().compareTo(arrayWithData.getSecondName()) > 0) {
                break;
            }

            prevRight = currentRight;
        }

        if ((currentRight == arrayWithDataForSearch.size() && arrayWithData.getFirstName().compareTo(arrayWithDataForSearch.get(currentRight).getFirstName()) > 0 &&
                arrayWithData.getSecondName().compareTo(arrayWithDataForSearch.get(currentRight).getSecondName()) > 0)) {
            return 0;
        }

        return backwardSearch(arrayWithDataForSearch, arrayWithData, prevRight, currentRight) + foundPos;
    }

    public static int backwardSearch(List<RepresentPhoneBook> arrayWithDataForSearch, RepresentPhoneBook arrayWithData, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
            if (arrayWithDataForSearch.get(i).getFirstName().equals(arrayWithData.getFirstName()) && arrayWithDataForSearch.get(i).getSecondName().equals(arrayWithData.getSecondName())) {
                return 0;
            }
        }
        return 1;
    }
}
