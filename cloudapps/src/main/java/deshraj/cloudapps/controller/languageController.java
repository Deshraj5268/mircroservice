package deshraj.cloudapps.controller;

import deshraj.cloudapps.dto.LanguageOutPutDto;
import deshraj.cloudapps.service.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "cloudapps/", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
public class languageController {

    @Autowired
    private TranslatorService translatorService;

    @GetMapping(path = "/language/{msgCode}")
    public ResponseEntity<LanguageOutPutDto> getInternationalMessage(@RequestBody @PathVariable(value = "msgCode") String msgCode){
        return new ResponseEntity<LanguageOutPutDto>(TranslatorService.toLocale(msgCode), HttpStatus.OK);
    }
}
