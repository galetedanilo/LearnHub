package com.galete.learnhub.api.user.dto.response;

public record AddressResponse(
        String publicPlace,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country,
        String zipCode
) {
}
