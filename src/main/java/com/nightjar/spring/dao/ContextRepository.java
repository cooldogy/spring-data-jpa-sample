package com.nightjar.spring.dao;

import com.nightjar.spring.entity.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContextRepository extends JpaRepository<Context, Long> {

    Context findByVersionName(String versionName);
}
