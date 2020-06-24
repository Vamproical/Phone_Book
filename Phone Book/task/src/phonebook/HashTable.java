package phonebook;

public class HashTable {
    private int size;
    private RepresentPhoneBook[] table;

    public HashTable(int size) {
        this.size = size;
        table = new RepresentPhoneBook[size];
    }

    public void put(RepresentPhoneBook representPhoneBook) {
        int idx = findKey(representPhoneBook);
        while (idx == -1) {
            rehash();
            idx = findKey(representPhoneBook);
        }
        table[idx] = new RepresentPhoneBook(representPhoneBook);
    }

    public String get(RepresentPhoneBook representPhoneBook) {
        int idx = findKey(representPhoneBook);

        if (idx == -1 || table[idx] == null) {
            return null;
        }

        return table[idx].getFirstName() + " " + table[idx].getSecondName();
    }

    private int findKey(RepresentPhoneBook representPhoneBook) {
        int key = 3;
        try {
            key = representPhoneBook.hashCode();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        int hash = key % size;

        while (!(table[hash] == null || table[hash].equals(representPhoneBook))) {
            if (hash % 2 == 0) {
                hash = ((hash + 1) * 2) % size;
            } else {
                hash = ((hash + 2) * 3) % size;
            }

            if (hash == key % size) {
                return -1;
            }
        }

        return hash;
    }

    private void rehash() {
        size *= 2;
        RepresentPhoneBook[] temp = table;
        table = new RepresentPhoneBook[size];
        for (RepresentPhoneBook en : temp) {
            put(en);
        }
    }
}

