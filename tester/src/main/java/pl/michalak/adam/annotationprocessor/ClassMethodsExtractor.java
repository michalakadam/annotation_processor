package pl.michalak.adam.annotationprocessor;

import java.lang.reflect.Method;

class ClassMethodsExtractor {
    Method[] extractMethodsFromClass(Class methodsProvider) {
        return methodsProvider.getMethods();
    }
}
