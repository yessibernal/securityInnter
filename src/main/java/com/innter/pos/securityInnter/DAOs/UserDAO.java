package com.innter.pos.securityInnter.DAOs;

import com.innter.pos.securityInnter.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE  u.username = :username")
    UserEntity getByUsername(@Param("username") String username);
}
