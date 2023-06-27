package com.innter.pos.securityInnter.DAOs;

import com.innter.pos.securityInnter.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDAO extends JpaRepository<RolEntity, Long> {
    @Query("SELECT r FROM RolEntity r WHERE  r.name = :name")
    RolEntity findByRolName(@Param("name") String name);
}
