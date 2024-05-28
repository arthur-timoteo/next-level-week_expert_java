package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifiIfHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.useCases.StudentCertificationAnsersUseCase;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifiIfHasCertificationUseCase;

@RestController
@RequestMapping("students")
public class StudentController {
    
    @Autowired
    private VerifiIfHasCertificationUseCase verifiIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnsersUseCase studentCertificationAnsersUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifiIfHasCertificationDTO verifyCertificationDTO){
        var result = this.verifiIfHasCertificationUseCase.execute(verifyCertificationDTO);

        if(result){
            return "Usuário já fez a prova";
        }
        
        return "Usuário pode fazer a prova";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {
            var result = this.studentCertificationAnsersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
