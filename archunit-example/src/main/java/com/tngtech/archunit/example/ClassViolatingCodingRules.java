package com.tngtech.archunit.example;

import java.util.logging.Logger;

public class ClassViolatingCodingRules {
    private static final Logger log = Logger.getLogger("Wrong Logger"); // Violates rule not to use java.util.logging

    public void printToStandardStream() {
        System.out.println("I'm gonna print to the command line"); // Violates rule not to write to standard streams
        System.err.println("I'm gonna print to the command line"); // Violates rule not to write to standard streams
        new SomeCustomException().printStackTrace(); // Violates rule not to write to standard streams
    }

    public void throwGenericExceptions() throws Throwable {
        if (Math.random() > 0.75) {
            throw new Throwable(); // Violates rule not to throw generic exceptions
        } else if (Math.random() > 0.25) {
            throw new Exception("Bummer"); // Violates rule not to throw generic exceptions
        } else {
            throw new RuntimeException("I have some cause", new Exception("I'm the cause")); // Violates rule not to throw generic exceptions
        }
    }

    public void thisIsOkay() {
        throw new SomeCustomException();
    }
}
