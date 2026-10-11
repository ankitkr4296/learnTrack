### JDK Version: 17 

### Explanation of Hello World:


`
public static void main(String[] args) {
        System.out.println("Hello World");
}
`

#### public static void main(String[] args) : This combined signature is the entry point of any Java Application

* public: Access Modifier - Sets the visibility of the method or class or variable
* static: Non-Access Modifier - Owned by class, not by instance and used mostly for memory management
* void: Method should not have a return value
* main(String[] args): Method name which expects Arrays of String as an argument. Here, it is a command line arguments

>> Why you may ask?
> The public Access Modifier let's JVM to execute this from anywhere and 
> since the method is static we don't need to create an instance of the class, we can run directly
> void indicates it does not have to return any value or data after it finishes executing
> whereas String[] args allow users to pass some command line arguments while launching the program

#### System.out.println("Hello World") : This is the print statement which is responsible for printing the "Hello World"

* System: Predefined Java class that provides access to the System resources
* out: Static member field within System class representing the standard output stream
* println(): 'print line'. Prints the text inside the parenthesis