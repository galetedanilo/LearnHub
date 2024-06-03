package com.galete.learnhub.api.user.dto.response;

import org.hibernate.validator.constraints.Length;

public record ContactResponse(
        String phone,
        String cellphone,
        String linkedin,
        String webSite
) {
}
