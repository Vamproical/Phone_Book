package phonebook;

import phonebook.SearchingAlgorithm.LinearSearch;
import phonebook.SortingAlgorithm.BubbleSort;

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

    public void init() {
        System.out.println("Start searching...");
        long startTime = System.currentTimeMillis();
        int found = LinearSearch.linearSearch(arrayWithData,arrayWithDataForSearch);
        long estimatedTime = System.currentTimeMillis() - startTime;
        long startSort = System.currentTimeMillis();
        BubbleSort.bubbleSort(arrayWithData);
        //BubbleSort.bubbleSort(arrayWithDataForSearch);
        long endSort = System.currentTimeMillis() - startSort;
        System.out.println("Time taken: " + printTime(endSort));
        System.out.println("Found " + found + " / 500 entries. Time taken: " + printTime(estimatedTime));
    }

    private String printTime(long estimatedTime) {
        long min, sec, milisec;
        min = estimatedTime / 60000;
        sec = (estimatedTime - min * 60000) / 1000;
        milisec = (estimatedTime - min * 60000 - sec * 1000);
        return min + " min. " + sec + " sec. " + milisec + " ms.";
    }
}
