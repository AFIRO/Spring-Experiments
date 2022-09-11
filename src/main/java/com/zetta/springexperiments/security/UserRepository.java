package com.zetta.springexperiments.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<InternalUser,Long> {
    Optional<InternalUser> findByUserName(String username);
}
