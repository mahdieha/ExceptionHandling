# Exception Handling
An [exception](https://www.tutorialspoint.com/java/java_exceptions.htm) (or exceptional event) is a problem that arises during the execution of a program. When an Exception occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.

An exception can occur for many different reasons. Following are some scenarios where an exception occurs.
  - A user has entered an invalid data.
  - A file that needs to be opened cannot be found.
  - A network connection has been lost in the middle of communications or the JVM has run out of memory.
  
# Class Hierarchy
![alt text](https://image.ibb.co/kQrY7a/exceptions1.jpg)

Based on these, we have three categories of Exceptions. You need to understand them to know how exception handling works in Java.

According to **Item 58 - Use checked exceptions for recoverable conditions and runtime exceptions for programming errors.** 
From [Effective Java 2/e](https://goo.gl/PgsN7i) by [Joshua Bloch](https://en.wikipedia.org/wiki/Joshua_Bloch) : 

##### The Java programming language provides three kinds of throwables:
**1. checked exceptions**
use checked exceptions for conditions from which the caller can reasonably be expected to recover
**2. runtime exceptions (unchecked exceptions)** 
Use runtime exceptions to indicate programming errors
all of the unchecked throwables you implement should subclass RuntimeException
**3. errors**

# Motivation
We have use [Chain Of Responsibility - Design Pattern](https://dzone.com/refcardz/design-patterns) for this porpuse.

![alt text](https://image.ibb.co/kFsWSa/10609_thumb.png)

**Example:** When an exception is thrown in a method the runtime checks to see if the method has a mechanism to handle the exception or if it should be passed up the call stack. 
When passed up the call stack the process repeats until code to handle the exception is encountered or until there are no more parent objects to hand the request to.

# Code Example
```ruby
/**
 * Exception handling HandleAble interface
 */
public interface HandleAble {
    boolean doHandle();
    }
```
```ruby
/**
* Runnable used for asynchronized exception handle.
*/
public class ExceptionHandlingAsync implements Runnable {
    private HandleAble handleAble;
    public ExceptionHandlingAsync(HandleAble handleAble) {
        this.handleAble = handleAble;
    }
    public void run() {
        handleAble.doHandle();
    }
}
```

 ```ruby
 /**
 * Exception Level 1: Critical 2: General 3: The greater the
 * non-significant exception value indicates that
 * the lower the level, the default is the non-critical exception
 */
public enum ExceptionLevel {
    SERIOUS(1, "serious"),
    COMMON(2, "common"),
    SLIGHT(3, "slight");

    private int value;

    private String description;

    ExceptionLevel(int value, String description) {
        this.value = value;
        this.description = description;
    }
 ```
### Built With

- [Maven](https://maven.apache.org/) - Dependency Management

## Authors
- **Mahdieh Asiaban - [mahdieha](https://github.com/mahdieha)**