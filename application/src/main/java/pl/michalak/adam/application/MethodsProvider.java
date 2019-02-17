package pl.michalak.adam.application;

import pl.michalak.adam.annotations.Run;

public class MethodsProvider {

    @Run
    public void printHelloMessage(){
        System.out.println("Hello, I am in a method marked with @Run annotation!");
    }

    public void doNotPrintAnything(){
        System.err.println("This method is not marked with @Run annotation.");
    }

    @Run
    void printPackagePrivateMessage(){
        System.out.println("Package-private methods work with @Run annotation as well.");
    }
}
