package edu.nyu.cs9053.homework6;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:21 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Vaccine {

    /**
     * @return the Disease for which this annotated object is vaccinated against
     */
    Disease cures();

    /**
     * @return the seed which created this vaccine for the associated {@linkplain edu.nyu.cs9053.homework6.Disease}
     */
    long seed() default Long.MIN_VALUE;

    /**
     * @return the antidote for the associated {@linkplain edu.nyu.cs9053.homework6.Disease}
     */
    String antidote() default "";

}
