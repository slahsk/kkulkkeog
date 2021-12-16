package com.kkulkkeog.user.v1.common.exception;

public class RegistrationNotFoundException extends RuntimeException{
    public RegistrationNotFoundException(String registrationId) {
        super(String.format("registrationId: %s NotFound", registrationId));
    }
}
