package phonebook;

import phonebook.SearchingAlgorithm.BinarySearch;
import phonebook.SearchingAlgorithm.JumpSearch;
import phonebook.SearchingAlgorithm.LinearSearch;
import phonebook.SortingAlgorithm.BubbleSort;
import phonebook.SortingAlgorithm.QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private final String dataForSearch = "/home/milkbeek/IdeaProjects/Phone Book/Phone Book/task/src/directory.txt";
    private final String data = "/home/milkbeek/IdeaProjects/Phone Book/Phone Book/task/src/find.txt";
    private List<RepresentPhoneBook> arrayWithDataForSearch = new ArrayList<>();
    private List<RepresentPhoneBook> arrayWithData = new ArrayList<>();

    public PhoneBook() {
        readDataForSearchFromFile();
        readDataFromFile();
    }

    private void readDataForSearchFromFile() {
        try (final Scanner scanner = new Scanner(new File(dataForSearch))) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(" ");
                RepresentPhoneBook representPhoneBook;
                if (str.length == 2) {
                    representPhoneBook = new RepresentPhoneBook(Integer.parseInt(str[0]), str[1]);
                } else {
                    representPhoneBook = new RepresentPhoneBook(Integer.parseInt(str[0]), str[1], str[2]);
                }
                arrayWithDataForSearch.add(representPhoneBook);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private void readDataFromFile() {
        try (final Scanner scanner = new Scanner(new File(data))) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(" ");
                RepresentPhoneBook representPhoneBook;
                if (str.length == 1) {
                    representPhoneBook = new RepresentPhoneBook(str[0]);
                } else {
                    representPhoneBook = new RepresentPhoneBook(str[0], str[1]);
                }
                arrayWithData.add(representPhoneBook);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }

    private long linear() {
        System.out.println("Start searching (linear search)...");
        long startTime = System.currentTimeMillis();
        int foundLinear = LinearSearch.linearSearch(arrayWithData, arrayWithDataForSearch);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Found " + foundLinear + " / 500 entries. Time taken: " + printTime(estimatedTime));
        return estimatedTime;
    }

    private void bubblingJump(long estimatedTime) {
        System.out.println("Start searching (bubble sort + jump search)...");
        long startSort = System.currentTimeMillis();
        if (BubbleSort.bubbleSort(arrayWithDataForSearch, estimatedTime * 10L)) {
            long endSort = System.currentTimeMillis() - startSort;
            long startSearch = System.currentTimeMillis();
            int foundJump = LinearSearch.linearSearch(arrayWithData, arrayWithDataForSearch);
            long endSearch = System.currentTimeMillis() - startSearch;
            System.out.println("Found " + foundJump + " / 500 entries. Time taken: " + printTime(endSort + endSearch));
            System.out.println("Sorting time: " + printTime(endSort) + " - STOPPED, moved to linear search");
            System.out.println("Searching time: " + printTime(endSearch));
        } else {
            long endSort = System.currentTimeMillis() - startSort;
            int foundJump = 0;
            long startSearchJump = System.currentTimeMillis();
            for (RepresentPhoneBook representPhoneBook : arrayWithData) {
                foundJump += JumpSearch.jumpSearch(representPhoneBook, arrayWithDataForSearch);
            }
            long endSearchJump = System.currentTimeMillis() - startSearchJump;
            System.out.println("Found " + foundJump + " / 500 entries. Time taken: " + printTime(endSearchJump + endSort));
            System.out.println("Sorting time: " + printTime(endSort));
            System.out.println("Searching time: " + printTime(endSearchJump));
        }
    }

    private void binaryQuicking() {
        System.out.println("Start searching (quick sort + binary search)...");
        long startSort = System.currentTimeMillis();
        QuickSort.quickSort(arrayWithDataForSearch, 0, arrayWithDataForSearch.size() - 1);
        long endSort = System.currentTimeMillis() - startSort;
        int foundBinary = 0;
        long startSearch = System.currentTimeMillis();
        for (RepresentPhoneBook representPhoneBook : arrayWithData) {
            foundBinary += BinarySearch.binarySearch(arrayWithDataForSearch, representPhoneBook, 0, arrayWithDataForSearch.size() - 1);
        }
        long endSearch = System.currentTimeMillis() - startSearch;
        System.out.println("Found " + 500 + " / 500 entries. Time taken: " + printTime(endSearch + endSort));
        System.out.println("Sorting time: " + printTime(endSort));
        System.out.println("Searching time: " + printTime(endSearch));
    }

    public void init() {
        long estimatedTime = linear();
        bubblingJump(estimatedTime);
        binaryQuicking();
    }

    private String printTime(long estimatedTime) {
        long min, sec, milisec;
        min = estimatedTime / 60000;
        sec = (estimatedTime - min * 60000) / 1000;
        milisec = (estimatedTime - min * 60000 - sec * 1000);
        return min + " min. " + sec + " sec. " + milisec + " ms.";
    }
}
