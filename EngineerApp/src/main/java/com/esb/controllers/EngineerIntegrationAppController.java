package com.esb.controllers;

import com.esb.entity.Engineer;
import com.esb.repository.EngineerRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PropertySource("classpath:constants.properties")
public class EngineerIntegrationAppController {

    public static final String YES = "yes";
    public static final String NO = "no";

    @Autowired
    private EngineerRepository engineerRepository;

    @GetMapping("/getAvailableEngineers/{referenceId}")
    public String getAvailableEngineers(@PathVariable String referenceId) {

        /**
         * Getting the first enginner that is available
         */
        Engineer engineer = engineerRepository.findFirst1ByAvailable(YES);

        // If any engineer is available
        if (ObjectUtils.allNotNull(engineer)) {
            engineer.setReferenceNumber(Long.valueOf(referenceId));
            engineer.setAvailable(NO);
            engineerRepository.save(engineer);
            return YES;
        }
        else{
            return NO;
        }






    }
}
