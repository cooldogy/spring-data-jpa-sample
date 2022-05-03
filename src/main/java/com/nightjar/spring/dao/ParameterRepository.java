package com.nightjar.spring.dao;

import com.nightjar.spring.entity.Context;
import com.nightjar.spring.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    @Query("select p from Parameter p where context =?1 and p.dbType = ?2")
    Parameter findByContextAndDBType(Context context, Integer dbType);
}
