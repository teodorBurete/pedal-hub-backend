package org.pedalhub.pedalhubbackend.entities.enums.bike;

public enum SuspensionType {
    RIGID("rigid"), HARDTAIL("hard-tail"), FULL("full-suspension");

    String value;

    SuspensionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
