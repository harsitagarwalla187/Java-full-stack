## Collections
Everything inside it are static.

### Methods of Collections
1. static void sort(List list); - ```Collections.sort(array);``` :  sorts the array
2. static void sort(List l, Comparator c);
3. static int binarySearch(List list, T key);
4. static void reverse(arr);
5. static void shuffle(List l);
6. static void swap(List list, int i, int j);
7. static void copy(List list, List)
8. static T min(Collection c)
8. static T min(Collection c, Comparator com)
9. static T max(Collection c)
9. static T max(Collection c, Comparator com)

## Arrays
This class contains various methods for manipulating arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be viewed as lists.

### Methods of Arrays
1. static void sort(int arr[]);
2. static void sort(int arr[], int fromIndex, int toIndex);
3. static int binarySearch(int arr[], int k)
4. static int binarySearch(int arr[], int fromIndex, int toIndex, int k)
5. static List asList(T..a) - Returns a fixed-size list backed by the specified array. 
     ```
     List<Integer> arr = new ArrayList<>(Arrays.asList(arr));
     ```

