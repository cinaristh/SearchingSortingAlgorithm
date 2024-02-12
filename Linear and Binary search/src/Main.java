public class Main {

    public static void main(String[] args) {
        // write your code here


        int[] mylist = {1, 3, 4, 7, 10, 13, 16, 18, 21, 22, 24, 25, 26, 31, 34, 37, 38, 42, 43, 44, 47, 51, 55, 57, 62, 65, 67, 68, 71, 76, 77, 80, 84, 86, 89, 91, 94, 97, 102, 103, 104, 108, 111, 114, 119, 120, 123, 126, 127, 132};
        int[] myUnsortedList = {13, 4, 7, 10, 1, 24, 16, 3, 18, 21, 22, 25, 26, 34, 31, 38, 42, 44, 47, 37, 43, 55, 57, 62, 65, 67, 68, 71, 76, 77, 80, 84, 86, 89, 91, 94, 97, 102, 103, 104, 108, 111, 114, 119, 120, 123, 126, 127, 132, 51};

        int item = 16;
        System.out.println(linSearch(mylist, item));


        System.out.println(binSearch(mylist, item));

        int[] sortedList = insertionSort(myUnsortedList);
        System.out.print("Insertion sorted list: ");
        printArray(sortedList);


        sortedList = quickSort(myUnsortedList, 0, mylist.length - 1);
        System.out.print("Quick sorted list: ");
        printArray(sortedList);
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static int linSearch(int[] mylist, int item) {
        int index = -1;
        int i = 0;
        boolean found = false;
        while ((i < mylist.length) & found == false) {
            if (mylist[i] == item) {
                index = i;
                found = true;


            }
            i = i + 1;


        }
        return index;


    }

    public static int binSearch(int[] mylist, int item) {
        int index = -1;
        boolean found = false;
        int first = 0;
        int last = mylist.length - 1;
        while (first <= last && !found) {
            int midpoint = (first + last) / 2;
            if (mylist[midpoint] == item) {
                found = true;
                index = midpoint;
            } else {
                if (item < mylist[midpoint]) {
                    last = midpoint - 1;
                } else {
                    first = midpoint + 1;
                }
            }
        }
        return index;
    }

    public static int[] insertionSort(int[] myUnsortedList) {
        int n = myUnsortedList.length;
        for (int index = 1; index < n; index++) {
            int currentValue = myUnsortedList[index];
            int position = index;
            while (position > 0 && myUnsortedList[position - 1] > currentValue) {
                myUnsortedList[position] = myUnsortedList[position - 1];
                position--;
            }
            myUnsortedList[position] = currentValue;
        }
        return myUnsortedList;
    }

    public static int partition(int[] myUnsortedList, int start, int end) {
        int pivot = myUnsortedList[start];
        int leftmark = start + 1;
        int rightmark = end;
        while (leftmark <= rightmark) {
            while (leftmark <= rightmark && myUnsortedList[leftmark] <= pivot) {
                leftmark++;
            }
            while (rightmark >= leftmark && myUnsortedList[rightmark] >= pivot) {
                rightmark--;
            }
            if (rightmark < leftmark) {
                break;
            } else {
                int temp = myUnsortedList[leftmark];
                myUnsortedList[leftmark] = myUnsortedList[rightmark];
                myUnsortedList[rightmark] = temp;
            }
        }
        int temp = myUnsortedList[start];
        myUnsortedList[start] = myUnsortedList[rightmark];
        myUnsortedList[rightmark] = temp;
        return rightmark;
    }

    // Quick sort function
    public static int[] quickSort(int[] myUnsortedList, int start, int end) {
        if (start < end) {
            int split = partition(myUnsortedList, start, end);
            quickSort(myUnsortedList, start, split - 1);
            quickSort(myUnsortedList, split + 1, end);
        }
        return myUnsortedList;

    }
}


