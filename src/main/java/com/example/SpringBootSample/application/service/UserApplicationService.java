package com.example.SpringBootSample.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class UserApplicationService {
   @Autowired
   private MessageSource messageSource;

   public Map<String, Integer> getGenderMap(Locale locale) {
      var genderMap = new LinkedHashMap<String, Integer>();
      genderMap.put(messageSource.getMessage("male", null, locale), 1);
      genderMap.put(messageSource.getMessage("female", null, locale), 2);
      return genderMap;
   }
}
