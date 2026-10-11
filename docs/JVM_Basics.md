## What is JDK, JRE, JVM?

### JDK

JDK is a Java Development Kit which contains the JRE and other useful tools like javac, jdb and javadoc
All these tools are required to run, compile, debug and document java code.

## JRE

JRE is a Java Runtime Environment which contains the JVM along with class libraries 
which is used to run the java applications. To run any java application we only need JRE.

### JVM

The JVM is the heart of the entire Java ecosystem. 
It is an abstract machine that provides the runtime environment where Java bytecode can be executed.


## What is bytecode?
The javac inside the JDK is responsible converting our .java (human readable) files to .class file and 
passed to JVM for converting into machine code which our computer can understand. It is the secret weapon that allows
Java to be Platform Independent


## What does “write once, run anywhere” mean?
We can write our Java code on one operating system (like a Mac) and run it on completely different operating systems 
(like Windows or Linux) without changing a single line of code or re-compiling it. This is possible due to the javac and JVM.
This bytecode is a universal language. Instead of talking to the hardware, it talks to the JVM. 
As long as a device has the JVM installed, it can read that bytecode and translate it into whatever local machine code that specific computer requires.

>> Write Once, Run Anywhere mean run anywhere the JVM is installed. JVM is platform dependent