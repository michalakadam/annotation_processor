package pl.michalak.adam.annotationtester;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class AnnotationChecker {
    Set<Method> collectOnlyMethodsWithAnnotation(Method[] methodsToCheck, Class annotationSupplier) {
        Set<Method> methodsWithAnnotation = new HashSet<>();
        for(Method method : methodsToCheck){
            method.setAccessible(true);
            if(checkIfAnnotationPresent(method, annotationSupplier))
                methodsWithAnnotation.add(method);
        }
        return methodsWithAnnotation;
    }

    private boolean checkIfAnnotationPresent(Method method, Class annotationSupplier) {
        return method.isAnnotationPresent(annotationSupplier);
    }
}
