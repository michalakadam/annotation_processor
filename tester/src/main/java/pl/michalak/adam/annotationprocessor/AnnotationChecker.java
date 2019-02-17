package pl.michalak.adam.annotationprocessor;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class AnnotationChecker {
    Set<Method> collectOnlyMethodsWithAnnotation(Method[] methodsToCheck, Class annotationProvider) {
        Set<Method> methodsWithAnnotation = new HashSet<>();
        for(Method method : methodsToCheck){
            if(checkIfAnnotationPresent(method, annotationProvider))
                methodsWithAnnotation.add(method);
        }
        return methodsWithAnnotation;
    }

    private boolean checkIfAnnotationPresent(Method method, Class annotationProvider) {
        return method.isAnnotationPresent(annotationProvider);
    }
}
