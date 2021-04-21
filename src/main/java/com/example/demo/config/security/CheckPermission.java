package com.example.demo.config.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public @interface CheckPermission {

    public @interface User {

        @PreAuthorize("hasAuthority('ROLE_USER_READ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface Read {
        }

        @PreAuthorize("hasAuthority('ROLE_USER_CREATE')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface Create {
        }

        @PreAuthorize("hasAuthority('ROLE_USER_UPDATE')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface Update {
        }

        @PreAuthorize("hasAuthority('ROLE_USER_DELETE')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface Delete {
        }

    }

}
