package com.develhope.Exercise0305;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @PostMapping("/addlanguage")
    public ProgrammingLanguage addLanguage(@RequestBody ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage newLanguage = programmingLanguageRepository.saveAndFlush(programmingLanguage);
        return newLanguage;
    }

    @GetMapping("/languages")
    public Page<ProgrammingLanguage> allLanguages() {
        Pageable pageable = PageRequest.of(0,2);
        Page<ProgrammingLanguage> allLanguages = programmingLanguageRepository.findAll(pageable);
        return allLanguages;
    }

    @PatchMapping("/inventorupd/{id}")
    public ProgrammingLanguage updateInventor(@PathVariable long id, @RequestParam String newInventor) {
        ProgrammingLanguage languageToUpdate = programmingLanguageRepository.getById(id);
        languageToUpdate.setInventor(newInventor);
        programmingLanguageRepository.saveAndFlush(languageToUpdate);
        return languageToUpdate;
    }

}


/*
	utilizza Postman per:
		aggiungere 4 linguaggi di programmazione:
		Java
		C++
		JavaScript
		Go
		prendere la lista di tutti i linguaggi di programmazione nella base dati, con la paginazione con 2 risultati nella pagina

*/
