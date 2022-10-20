package com.sports.registration.dto.mapper;

import com.sports.registration.dto.request.RegistrationDTO;
import com.sports.registration.entity.Registration;

public class RegistrationMapper {
    public static RegistrationDTO toDTO(Registration registration){
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setCategoryId(registration.getCategoryId());
        registrationDTO.setRegisterStatus(registration.getRegisterStatus());
        registrationDTO.setDate(registration.getDate());
        registrationDTO.setUserId(registration.getUserId());
        return registrationDTO;
    }

    public static Registration toModel(RegistrationDTO registrationDTO){
        Registration registration = new Registration();
        registration.setCategoryId(registrationDTO.getCategoryId());
        registration.setRegisterStatus(registrationDTO.getRegisterStatus());
        registration.setUserId(registrationDTO.getUserId());
        registration.setDate(registrationDTO.getDate());
        return registration;
    }


}
