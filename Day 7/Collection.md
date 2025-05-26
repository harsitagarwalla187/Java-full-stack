## Collection framework was introduced in Java v8
It comes under the package java.util

## List Interface
It extends the collection framework
- Duplicate values allowed
- Insertion Order must be preserved
- Homogenous and Heterogenous

## Methods of Collection Interface
1. boolean add(Object e)
2. boolean addAll(Collection c)
3. booelan remove(Object e) - removes the first value
4. boolean removeAll(Collection c)
5. void clear()
6. boolean isEmpty()

## Methods of List Interface
1. void add(int index, E value) - add value to this index and shifts oders by 1
2. void set(int index, E value) - replace the value in the index
3. E get(int index) - returns the value in the index

## ArrayList
Syntax: ``` ArrayList<Integer> arr = new ArrayList<>();``` - Integer(Wrapper Class) is used as Generic Class doesn't accepts primitive datatype
- ArrayList is defined using Dynamic Array, so it's resizable
- Duplicates are allowed
- Order of elements are preserved
- Null Insertion is possible
- Heterogenous objects are allowed
-  Capacity of ArrayList increases by (Capacity * 3/2) + 1 

## LinkedList
Syntax: ``` LinkedList<Integer> list = new  LinkedList<>();```

## Methods of LinkedList
1. void addFirst(Object obj); 
2. void addLast(Object obj); 
3. Object getLast();
4. Object getFirst();
5. Object removeFirst();
6. Object removeLast();

## Stack
Syntax: ``` List<Integer> st = new Stack<>(); ```

## Methods of Stack
1. void push(Object obj)
2. Object pop()
3. Object peek()
4. boolean empty()