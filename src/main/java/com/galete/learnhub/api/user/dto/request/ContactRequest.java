package com.galete.learnhub.api.user.dto.request;

import org.hibernate.validator.constraints.Length;

public record ContactRequest(
        @Length(max = 15, message = "Maximum 15 characters") String phone,
        @Length(max = 15, message = "Maximum 15 characters") String cellphone,
        @Length(max = 100, message = "Maximum 100 characters") String linkedin,
        @Length(max = 100, message = "Maximum 100 characters") String webSite
) {
}
