package pl.michalak.adam.annotationprocessor;

import pl.michalak.adam.annotations.Run;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;


@SupportedAnnotationTypes("pl.michalak.adam.annotations.Run")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomProcessor extends AbstractProcessor {

    public CustomProcessor(){
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(Element element : roundEnv.getElementsAnnotatedWith(Run.class)) {
            String message = "annotation @Run found in " + element.getSimpleName();
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
        }
        return true;
    }
}
