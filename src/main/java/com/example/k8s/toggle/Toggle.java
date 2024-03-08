package com.example.k8s.toggle;

public enum Toggle {

    STARTUP("startup-probe"),
    READINESS("readiness-probe"),
    LIVENESS("liveness-probe");

    private String key;

    Toggle(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

}
