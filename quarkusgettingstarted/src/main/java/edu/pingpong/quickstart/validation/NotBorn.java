package edu.pingpong.quickstart.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

// Add constraint 
// Annotation created
@Constraint(validatedBy = {NotBornValidator.class})

public @interface NotBorn {
    
    String message() default "Beer must not be expired"; 
    Class<?>[] groups() default { }; 
    Class<? extends Payload>[] payload() default { };
}
