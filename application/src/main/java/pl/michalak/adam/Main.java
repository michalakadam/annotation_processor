package pl.michalak.adam;

import pl.michalak.adam.annotationtester.AnnotatedMethodsRunner;
import pl.michalak.adam.annotations.Run;
import pl.michalak.adam.application.MethodsProvider;

class Main {
    public static void main(String[] args) {
        new AnnotatedMethodsRunner(new MethodsProvider(), Run.class).runMethodsProviderClassMethodsWithAnnotation();
    }
}
