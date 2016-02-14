package com.panichmaxim.alphastrah.controller.db.annotations;

import java.lang.annotation.*;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ForeignKey {
    String name();
}
