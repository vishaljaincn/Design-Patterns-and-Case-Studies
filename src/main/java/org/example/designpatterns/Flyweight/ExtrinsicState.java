
package org.example.designpatterns.Flyweight;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to indicate extrinsic state in the Flyweight design pattern.
 * Extrinsic state is the part of the state that can be passed from the client
 * to the Flyweight object and is not shared.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExtrinsicState {
}

/*
    - `@Retention(RetentionPolicy.RUNTIME)`: This indicates that the annotation is available at runtime.
      The retention policy specifies how long the annotation should be retained, and `RUNTIME` means
      the annotation is retained by the JVM so it can be used by the runtime environment.

    - `@Target(ElementType.TYPE)`: This indicates that the annotation can be applied to types, which includes
      classes, interfaces, enums, and annotations.

    - `public @interface ExtrinsicState`: This defines a custom annotation named `ExtrinsicState`.
      This annotation can be used to mark classes that contain extrinsic state in the Flyweight design pattern.
*/
