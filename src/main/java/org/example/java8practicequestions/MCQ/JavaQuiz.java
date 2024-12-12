package org.example.java8practicequestions.MCQ;

public class JavaQuiz {
    public static void main(String[] args) {
        try {
            System.out.print(1 / 0);
        } catch (Exception e) {
            System.out.print("Exception");
        }
//        catch (ArithmeticException f) {
//            System.out.print("ArithmeticException");
//        }
    }
}
/*
The code provided contains a syntax error due to the incorrect order of the catch blocks.

Here’s a breakdown of why this happens:

### Code Analysis:

java
try {
    System.out.print(1/0);  // This will throw an ArithmeticException
} catch (Exception e) {
    System.out.print("Exception");
} catch (ArithmeticException f) {
    System.out.print("ArithmeticException");
}


- The try block executes System.out.print(1/0);, which will cause an ArithmeticException because dividing by zero is not allowed in Java.

- The first catch block is catch(Exception e). This block can catch any exception that is a subclass of Exception, including ArithmeticException.

- The second catch block is catch(ArithmeticException f). This is specifically designed to catch ArithmeticException.

### The Issue:
In Java, the catch blocks must be ordered from the most specific exception type to the most general one. Since ArithmeticException is a subclass of Exception, the catch(Exception e) block will catch ArithmeticException as well. Therefore, the second catch (ArithmeticException f) is unreachable.

### What happens:
1. The first catch (Exception e) block will catch the ArithmeticException.
2. The second catch (ArithmeticException f) will never be executed because Exception can already catch all exceptions, including ArithmeticException.

### Compilation Error:
Because of the unreachable catch (ArithmeticException f) block, the Java compiler will throw a *compilation error*.

### Correct Answer:
*Compilation error*
 */