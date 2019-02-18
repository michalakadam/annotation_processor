package pl.michalak.adam.annotationtester;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * This public API handles invoking methods from injected methodsSupplier class
 * with specified annotation defined in annotationSupplier class.
 *
 */
public class AnnotatedMethodsRunner {

    private Object methodsSupplier;
    private Class annotationSupplier;

    /**
     * @param methodsSupplier is a source of methods to invoke
     * @param annotationSupplier defines a type of annotation
     */
    public AnnotatedMethodsRunner(Object methodsSupplier, Class annotationSupplier) {
        this.methodsSupplier = methodsSupplier;
        this.annotationSupplier = annotationSupplier;
    }

    /**
     * Responsible for invoking methods from methodsSupplier class
     * that are first filtered according to the annotation defined
     * in annotationSupplier class.
     */
    public void runMethodsProviderClassMethodsWithAnnotation() {
        Method[] methodsToCheck = getMethodsToCheck();
        Set<Method> methodsWithAnnotation = getMethodsWithAnnotation(methodsToCheck);
        methodsWithAnnotation.forEach(method -> {
            try {
                method.invoke(methodsSupplier);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.err.format("Caused by invoking method %s located in class %s", method.getName(), method.getClass().getName());
            }
        });
    }

    private Method[] getMethodsToCheck() {
        return methodsSupplier.getClass().getDeclaredMethods();
    }

    private Set<Method> getMethodsWithAnnotation(Method[] methodsToCheck) {
        return  new AnnotationChecker().collectOnlyMethodsWithAnnotation(methodsToCheck, annotationSupplier);
    }
}
