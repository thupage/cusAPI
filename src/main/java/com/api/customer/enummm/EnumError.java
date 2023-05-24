package com.api.customer.enummm;

public enum EnumError {

    NOT_EMPTY("_required");

    private String name;

    EnumError(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
