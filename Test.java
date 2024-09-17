import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Test {

    // use random to test outcomes against normal array list - stress test

    static int getRandomNumber(int maxNumber) {
        Random r = new Random();
        return r.nextInt(0, maxNumber + 1);
    }
    static int getRandomNumber(int minNumber, int maxNumber) {
        Random r = new Random();
        return r.nextInt(minNumber, maxNumber + 1);
    }



    static int[] generateRandomList() {
        int length = getRandomNumber(1, 100);
        int[] data = new int[length];

        for (int i = 0; i < data.length; i++) {
            data[i] = getRandomNumber(1000);
        }
        return data;
    }
    // write it then give to others
    static boolean runTest() {
        int testToRun = getRandomNumber(8);
        int[] data = generateRandomList();

        ArrayList<Integer> a = new ArrayList<>();
        MyArrayList<Integer> b = new MyArrayList<>();

        for (int i : data) {
            a.add(i);
            b.add(i);
        }


        if (testToRun == 0) {
            // add
            if (getRandomNumber(1) == 0) {
                // just add
                return addTestNoIndex(a, b);
            } else {
                // add to random index
                return addTestIndex(a, b);
            }

        } else if (testToRun == 1) {
            // size
            return sizeTest(a, b);
        } else if (testToRun == 2) {
            // set
            return setTest(a, b);

            // chose a random index and do that one

        } else if (testToRun == 3) {
            // remove


            return removeTest(a, b);
            // chose a random index

        } else if (testToRun == 4) {
            // indexOf
            return indexOfTest(a, b);
            // chose random number

        } else if (testToRun == 5) {
            // get
            return getTest(a, b);
            // chose random index

        } else if (testToRun == 6) {
            // contains
            return containsTest(a, b);
            // chose random number

        } else if (testToRun == 7) {
            // to string

            return toStringTest(a, b);
        } else {
            // is empty
            return isEmptyTest(a, b);
        }
    }


    static boolean same(ArrayList<Integer> a, MyArrayList<Integer> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (!Objects.equals(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean addTestNoIndex(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int number = getRandomNumber(1000);
        a.add(number);
        b.add(number);

        return same(a, b);
    }

    static boolean addTestIndex(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int index = getRandomNumber(Math.min(a.size(), b.size()) - 1);
        int number = getRandomNumber(1000);

        a.add(index, number);
        b.add(index, number);
        return same(a, b);
    }

    static boolean sizeTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        return (a.size() == b.size());
    }

    static boolean setTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int index = getRandomNumber(Math.min(a.size(), b.size()) - 1);
        int number = getRandomNumber(1000);

        a.set(index, number);
        b.set(index, number);
        return same(a, b);
    }

    static boolean removeTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int index = getRandomNumber(Math.min(a.size(), b.size()) - 1);
        a.remove(index);
        b.remove(index);
        return same(a, b);
    }

    static boolean indexOfTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int number = getRandomNumber(10000);
        return a.indexOf(number) == b.indexOf(number);
    }


    static boolean getTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int index = getRandomNumber(Math.min(a.size(), b.size()) - 1);
        return Objects.equals(a.get(index), b.get(index));
    }

    static boolean containsTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        int number = getRandomNumber(10000);
        return a.contains(number) == b.contains(number);
    }

    static boolean toStringTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        return a.toString().equals(b.toString());
    }

    static boolean isEmptyTest(ArrayList<Integer> a, MyArrayList<Integer> b) {
        return a.isEmpty() == b.isEmpty();
    }

    public static void main(String[] args) {

        int tests = 1000;
        // Runs 1000 random test each with a random array
        for (int i = 0; i < tests; i++) {
            System.out.println(runTest());
        }


    }
}