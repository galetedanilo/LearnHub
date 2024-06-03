package com.galete.learnhub.api.user.dto.request;

import org.hibernate.validator.constraints.Length;

public record AddressRequest(
        @Length(max = 200, message = "Maximum 200 characters") String publicPlace,
        @Length(max = 8, message = "Maximum 8 characters") String number,
        @Length(max = 50, message = "Maximum 50 characters") String complement,
        @Length(max = 50, message = "Maximum 50 characters") String neighborhood,
        @Length(max = 100, message = "Maximum 100 characters") String city,
        @Length(max = 100, message = "Maximum 100 characters") String state,
        @Length(max = 100, message = "Maximum 100 characters") String country,
        @Length(max = 10, message = "Maximum 10 characters") String zipCode
) {
}
