package com.sports.registration.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationPostDTO {
    private String categoryId;
    private String eventId;
    private String userId;
}
