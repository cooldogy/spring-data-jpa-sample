package com.nightjar.spring.dao;

import com.nightjar.spring.entity.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ResourceRepositoryTest {

    @Autowired
    private ContextRepository contextRepository;

    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    public void testSave() {
        log.info("testSave start ...");
        resourceRepository.save(
                Resource.builder()
                        .parameter(parameterRepository.findByContextAndDBType(contextRepository.findByVersionName("crm360"), 0))
                        .host("vm-tram1.ps.oas")
                        .port(3306)
                        .username("cccrm360")
                        .password("oasuser")
                        .databaseName("cccrm360_shared")
                        .build());
        log.info("testSave end ...");
    }

}
