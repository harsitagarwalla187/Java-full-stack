## Stream API

### Creating a Stream
```java
List<Integer> numbers = List.of(10, 20, 30, 40);
Stream<Integer> stream = numbers.stream();             // Sequential
Stream<Integer> parallel = numbers.parallelStream();   // Parallel
```

###  Intermediate Operations (return a new stream):
| Operation     | Description                         |
| ------------- | ----------------------------------- |
| `.filter()`   | Filters elements based on condition |
| `.map()`      | Transforms elements                 |
| `.sorted()`   | Sorts the stream                    |
| `.distinct()` | Removes duplicates                  |
| `.limit(n)`   | Limits to first `n` elements        |

### Terminal Operations (trigger computation):
| Operation     | Description                        |
| ------------- | ---------------------------------- |
| `.forEach()`  | Performs an action on each element |
| `.collect()`  | Converts to List, Set, etc.        |
| `.reduce()`   | Combines elements into one result  |
| `.count()`    | Counts elements                    |
| `.anyMatch()` | Checks if any element matches      |

### Difference between .map() and .filter()
| Feature            | `.map()`                                    | `.filter()`                                |
| ------------------ | ------------------------------------------- | ------------------------------------------ |
| **Purpose**        | Transforms each element into something else | Keeps only elements that match a condition |
| **Return Type**    | Stream of the same size (but transformed)   | Stream with fewer (or same) elements       |
| **Input → Output** | One input → One output (transformed)        | One input → Zero or one output             |
| **Use Case**       | Convert, modify, or extract values          | Select values based on a condition         |

### Collector
| Collector                       | Description                           |
| ------------------------------- | ------------------------------------- |
| `toList()`                      | Collects elements into a `List`       |
| `toSet()`                       | Collects elements into a `Set`        |
| `toMap(keyMapper, valueMapper)` | Collects elements into a `Map`        |
| `joining(delimiter)`            | Concatenates strings with delimiter   |
| `groupingBy(classifier)`        | Groups elements by a property         |
| `counting()`                    | Counts elements                       |
| `summarizingInt(...)`           | Returns count, sum, min, average, max |
