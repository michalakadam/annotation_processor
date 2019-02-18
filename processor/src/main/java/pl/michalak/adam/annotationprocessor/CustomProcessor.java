package pl.michalak.adam.annotationprocessor;

import pl.michalak.adam.annotations.Run;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;


/**
 * Custom implementation of annotation processor using
 * javax.annotation.processing API. Processor checks during
 * compilation phase if there are methods annotated with @Run
 * annotation and writes their names to the file.
 */

@SupportedAnnotationTypes("pl.michalak.adam.annotations.Run")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomProcessor extends AbstractProcessor {


    /**
     * Processes a set of annotation types of size 1 on type elements.
     * As a result methods with @Run annotation are printed to a file
     * "processingResult.txt" in project folder.
     * @param annotations the annotation types requested to be processed
     * @param roundEnv environment for information about the current and prior round
     * @return whether set of annotations are claimed by this processor - in this case always true
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(Element element : roundEnv.getElementsAnnotatedWith(Run.class)) {
            String message = "annotation @Run found in " + element.getSimpleName();
            try(FileWriter fileWriter = new FileWriter("processingResult.txt")){
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(message);
                }
            } catch (IOException e) {
                System.err.println("Thrown while writing annotation processor message to file");
            }
        }
        return true;
    }
}
