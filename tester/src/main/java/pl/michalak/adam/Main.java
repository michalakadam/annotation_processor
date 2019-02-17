package pl.michalak.adam;

import pl.michalak.adam.annotationprocessor.AnnotatedMethodsRunner;
import pl.michalak.adam.annotations.Run;
import pl.michalak.adam.application.MethodsProvider;

/**
 * Annotation Processor takes a class with methods and class where annotation is defined
 * and acts on methods with annotation according to the specification.
 *
 * @author Adam Michalak
 */
class Main {
public static void main(String[] args) {
        AnnotatedMethodsRunner annotatedMethodsRunner = AnnotatedMethodsRunner.create(MethodsProvider.class, Run.class);
        annotatedMethodsRunner.runMethodsProviderClassMethodsWithAnnotation();
    }
}
