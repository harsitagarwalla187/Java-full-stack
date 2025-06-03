### Garbage Collection
- Garbage Collection is the process of automatically reclaiming memory by deleting objects that are no longer reachable or used in a Java program.
- It helps prevent memory leaks and improves application performance.

| Term            | Description                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------- |
| **Heap Memory** | Memory area where all class instances and arrays are allocated.                                 |
| **Garbage**     | Objects that are no longer referenced by any part of the code.                                  |
| **GC**          | The automatic process that deallocates memory of unreachable objects.                           |
| **Reference**   | A variable that points to an object in memory. When no references exist, the object is garbage. |

#### finalize()
- finalize() is a method in the Object class in Java.
- It is called by the Garbage Collector before an object is destroyed.
- Used to perform cleanup operations like closing files, releasing resources, etc.

### final vs finally vs finalize

| Term           | Type                  | Purpose                                                      | Usage Example                                |
| -------------- | --------------------- | ------------------------------------------------------------ | -------------------------------------------- |
| **`final`**    | Keyword               | Prevents modification (of variables, methods, or classes)    | `final int x = 10;`                          |
| **`finally`**  | Block (in try-catch)  | Ensures code always executes (cleanup, closing resources)    | `try { ... } finally { ... }`                |
| **`finalize`** | Method (Object class) | Called by GC before object is garbage collected (deprecated) | `protected void finalize() throws Throwable` |
