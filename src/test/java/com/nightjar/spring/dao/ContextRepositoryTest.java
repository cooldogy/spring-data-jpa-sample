package com.nightjar.spring.dao;

import com.nightjar.spring.entity.Context;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
public class ContextRepositoryTest {

    @Autowired
    private ContextRepository repository;

    @Test
    public void testSave() {
        log.info("testSave start ...");
        repository.save(
                Context.builder()
                        .versionName("crm360")
                        .path("/crm360")
                        .workDir("C:/home/git/decall.3.6")
                        .build());
        log.info("testSave end ...");
    }

    @Test
    public void testFindByVersionName() {
        log.info("testFindByVersionName start ...");
        Context context = repository.findByVersionName("crm360");
        log.info(context.getWorkDir());
        log.info("testFindByVersionName end ...");
    }

    @Test
    public void testFindAll() {
        log.info("testFindAll start ...");
        List<Context> contextList = repository.findAll();
        assertEquals(1, contextList.size());
        log.info("testFindAll end ...");
    }

}
