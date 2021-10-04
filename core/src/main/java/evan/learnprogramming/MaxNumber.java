package evan.learnprogramming;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})  // this line annotates the context in which an annotation type is applicable
//So our annotion MaxNumber can be added to fields, parameters and/or methods.
@Retention(RetentionPolicy.RUNTIME) //how long are the annotation are the be retained
@Qualifier //Spring annotation used to annotate other custom annotations
public @interface MaxNumber {


}
