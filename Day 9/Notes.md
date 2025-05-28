## Comparator
- It is used for custom sorting order.

#### Comparator Function Return Values:
Given two elements a and b, a comparator function compare(a, b) returns:
1. Negative value (< 0): a should come before b.
2. Zero (0): a and b are equal in order.
3. Positive value (> 0): a should come after b.

## Comparable
- It is used for default natural sorting order.

## Lambda Expressions
- It has no name
- It has no return type
- It has no modifier
```java
(int a, int b) -> {
    return a+b;
}
```
```java
(int a, int b) -> a+b;
```

## Functional Interface
An Interface that contains only one Method is termed a functional interface.

Lambda expressions are called by functional interface.
```java
Interface MyInterface {
    void myMethod(); 
}

MyInterface mi = () -> System.out.println("My Lambda expresison.");
mi.myMethod();
```

