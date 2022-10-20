package com.sports.registration.service;

import com.sports.registration.dto.mapper.RegistrationMapper;
import com.sports.registration.dto.request.RegistrationDTO;
import com.sports.registration.entity.Registration;
import com.sports.registration.exception.UserIdNotFoundException;
import com.sports.registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<RegistrationDTO> getAllRegisterList() throws UserIdNotFoundException {
        List<Registration> registrations = null;
        registrations = registrationRepository.findAll();
        return registrations.stream().map(RegistrationMapper::toDTO).collect(Collectors.toList());
    }

    public List<RegistrationDTO> getRegisterListByUser(String userId) throws UserIdNotFoundException {
        List<Registration> registrations = null;
        registrations = registrationRepository.findByUserId(userId);
        return registrations.stream().map(RegistrationMapper::toDTO).collect(Collectors.toList());
    }

    public void createRegister(RegistrationDTO registrationDTO) {
        LocalDate now = LocalDate.now();
        registrationDTO.setDate(now);
        registrationRepository.save(RegistrationMapper.toModel(registrationDTO));
    }

    public void deleteRegister(String registrationId){
        registrationRepository.deleteById(registrationId);
    }
}
