package pl.michalak.adam.annotationprocessor;

import pl.michalak.adam.application.MethodsProvider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class AnnotatedMethodsRunner {

    private Class methodsProvider;
    private Class annotationProvider;

    private AnnotatedMethodsRunner(Class methodsProvider, Class annotationProvider) {
        this.methodsProvider = methodsProvider;
        this.annotationProvider = annotationProvider;
    }

    public void runMethodsProviderClassMethodsWithAnnotation() {
        Method[] methodsToCheck = getMethodsToCheck();
        Set<Method> methodsWithAnnotation = getMethodsWithAnnotation(methodsToCheck);
        methodsWithAnnotation.forEach(method -> {
            try {
                method.invoke(new MethodsProvider());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

    }

    private Method[] getMethodsToCheck() {
        return new ClassMethodsExtractor().extractMethodsFromClass(methodsProvider);
    }

    private Set<Method> getMethodsWithAnnotation(Method[] methodsToCheck) {
        return  new AnnotationChecker().collectOnlyMethodsWithAnnotation(methodsToCheck, annotationProvider);
    }

    public static AnnotatedMethodsRunner create(Class methodsProvider, Class annotationProvider) {
        return new AnnotatedMethodsRunner(methodsProvider, annotationProvider);
    }
}
