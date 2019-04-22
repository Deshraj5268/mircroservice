package deshraj.cloudapps.service;

import deshraj.cloudapps.dto.LanguageOutPutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TranslatorService {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    TranslatorService(ResourceBundleMessageSource messageSource) {
        TranslatorService.messageSource = messageSource;
    }

    public static LanguageOutPutDto toLocale(String msgCode) {
        LanguageOutPutDto languageOutPutDto = new LanguageOutPutDto();
        Locale locale = LocaleContextHolder.getLocale();
         languageOutPutDto.setMessage(messageSource.getMessage(msgCode, null, locale));
         return languageOutPutDto;
    }
}
