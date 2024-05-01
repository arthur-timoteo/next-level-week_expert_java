package com.rocketseat.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifiIfHasCertificationDTO;

@Service
public class VerifiIfHasCertificationUseCase {
    
    public boolean execute(VerifiIfHasCertificationDTO dto){
        if(dto.getEmail().equals("arthur@bol.com") && dto.getTechnology().equals("JAVA")){
            return true;
        }

        return false;
    }

}
