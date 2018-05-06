package com.health.health.security.enums;

/**
 * Created by jdms3112 on 5/3/2018.
 */
public enum Role {

    ADMIN, PHARMACY, USER;

    public static Role value(String name) {
        return Role.valueOf(name.toUpperCase());
    }

    public static Role value(Integer ordinal) {
        return Role.values()[ordinal];
    }

    @Override
    public String toString() {
        return this.name();
    }
}
