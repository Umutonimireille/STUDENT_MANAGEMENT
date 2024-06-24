package com.intake21.customapp.enums;

public enum EGender {
    MALE("Male"), FEMALE("Female"), OTHER(
            "Not specified");
    private final String eGenderDescription;

    EGender(String eGenderDescription) {
        this.eGenderDescription = eGenderDescription;
    }

    public String getEGenderDescription() {
        return eGenderDescription;
    }

}
