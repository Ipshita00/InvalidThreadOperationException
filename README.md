# InvalidThreadOperationException
# Multi-threaded Java Application with Error Handling

## 🧾 Description

This project demonstrates a Java multi-threaded application that includes proper synchronization and exception handling. It consists of two types of threads:

1. **NumberPrinter Thread**  
   - Prints numbers from 1 to 10, with a 1-second delay between each print.

2. **FactorialCalculator Thread**  
   - Calculates factorials of numbers from 1 to 5 in parallel.

The application also includes:
- Custom exception handling (`InvalidThreadOperationException`)
- Synchronization of critical sections to ensure thread safety
- Graceful thread completion using `join()`

---

## 🧪 Features

- Multi-threaded execution
- Thread synchronization using `synchronized`
- Custom exception for invalid factorial input
- Exception handling for thread interruptions

---

## 🛠️ How to Run

1. **Compile the program**

   ```bash
   javac MultiThreadedApp.java
