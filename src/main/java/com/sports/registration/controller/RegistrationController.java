package com.sports.registration.controller;

import com.sports.registration.dto.request.RegistrationDTO;
import com.sports.registration.exception.UserIdNotFoundException;
import com.sports.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sports/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createRegistration(@RequestBody @Valid RegistrationDTO registrationDTO) {
        registrationService.createRegister(registrationDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationDTO> getRegistration(@RequestParam(name = "user", required = false) String userId)
            throws UserIdNotFoundException {
        List<RegistrationDTO> registers = null;
        if (userId == null || userId.isEmpty()){
            registers = registrationService.getAllRegisterList();
        } else {
            registers = registrationService.getRegisterListByUser(userId);
        }

        return  registers;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRegistration(@PathVariable(required = true) String registrationId){
        registrationService.deleteRegister(registrationId);
    }


}
