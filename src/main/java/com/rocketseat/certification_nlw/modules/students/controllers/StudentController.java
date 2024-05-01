package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.VerifiIfHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifiIfHasCertificationUseCase;

@RestController
@RequestMapping
public class StudentController {
    
    @Autowired
    private VerifiIfHasCertificationUseCase verifiIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifiIfHasCertificationDTO verifyCertificationDTO){
        var result = this.verifiIfHasCertificationUseCase.execute(verifyCertificationDTO);

        if(result){
            return "Usuário já fez a prova";
        }
        
        return "Usuário pode fazer a prova";
    }

}
