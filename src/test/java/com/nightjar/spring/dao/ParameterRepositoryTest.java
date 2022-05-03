package com.nightjar.spring.dao;

import com.nightjar.spring.entity.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ParameterRepositoryTest {

    @Autowired
    private ContextRepository contextRepository;

    @Autowired
    private ParameterRepository parameterRepository;

    @Test
    public void testSave() {
        log.info("testSave start ...");
        parameterRepository.save(
                Parameter.builder()
                        .context(contextRepository.findByVersionName("crm360"))
                        .value("cccrm360_shared")
                        .dbType(0)
                        .build());
        log.info("testSave end ...");
    }
}
