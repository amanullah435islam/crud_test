package com.example.enums;

public enum Role {

    DOCTOR,
    PATIENT,
    ADMIN;

    // Returns Spring Security compatible authority string
    public String getAuthority() {
        return "ROLE_" + this.name();
    }

}
