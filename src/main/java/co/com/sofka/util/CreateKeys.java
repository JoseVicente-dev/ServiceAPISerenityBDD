package co.com.sofka.util;

public enum CreateKeys {
    NAME("[name]"),
    JOB("[job]");

    private final String value;

    CreateKeys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}