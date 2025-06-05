## Thread
A Thread in Java is a lightweight subprocess, the smallest unit of processing. It is a part of the Java ```java.lang package``` and enables concurrent execution of two or more parts of a program for maximum utilization of CPU.

## MultiThreading
- Multithreading is the ability of a single program to execute multiple threads concurrently.
- Each thread is a lightweight subprocess, and they share the same memory space but run independently

## MultiProgramming
- Multiprogramming is the ability of an operating system to run multiple programs concurrently by managing CPU time between them.
- It doesn’t mean all programs run at once; the OS rapidly switches between them (context switching).

### Ways to create and run thread :
1. By Extending the Thread class
2. By Implementing the Runnable interface

### Objective:
1. Create a thread
2. Attach code to thread
3. Execute thread

## Thread State
In Java, a thread can be in one of several states during its lifecycle. These states are defined in the ```Thread.State``` enum, and they reflect what the thread is doing at a given moment.

| State           | Description                                                                                       |
| --------------- | ------------------------------------------------------------------------------------------------- |
| `NEW`           | Thread is created but **not yet started** (`start()` not called).                                 |
| `RUNNABLE`      | Thread is ready to run or is **running** (depends on CPU scheduling).                             |
| `BLOCKED`       | Thread is waiting to acquire a **lock** (e.g., synchronized block is occupied).                   |
| `WAITING`       | Thread is waiting **indefinitely** for another thread to do something (e.g., `join()`, `wait()`). |
| `TIMED_WAITING` | Thread is waiting for a **specific period** (e.g., `sleep(ms)`, `join(ms)`).                      |
| `TERMINATED`    | Thread has **finished** execution or **was aborted** due to an exception.                         |

