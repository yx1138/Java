package edu.nyu.cs9053.homework6;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * User: blangel
 * Date: 10/5/14
 * Time: 8:16 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Infection {

    /**
     * @return the disease with which the annotation object is infected
     */
    Disease cause();

}
