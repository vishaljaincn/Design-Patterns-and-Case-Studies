package org.example.designpatterns.Flyweight;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to indicate intrinsic state in the Flyweight design pattern.
 * Intrinsic state is the part of the state that is shared between different Flyweight objects.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IntrinsicState {
}

/*
    - `@Retention(RetentionPolicy.RUNTIME)`: This indicates that the annotation is available at runtime.
      The retention policy specifies how long the annotation should be retained, and `RUNTIME` means
      the annotation is retained by the JVM so it can be used by the runtime environment.

    - `@Target(ElementType.TYPE)`: This indicates that the annotation can be applied to types, which includes
      classes, interfaces, enums, and annotations.

    - `public @interface IntrinsicState`: This defines a custom annotation named `IntrinsicState`.
      This annotation can be used to mark classes that contain intrinsic state in the Flyweight design pattern.
*/
