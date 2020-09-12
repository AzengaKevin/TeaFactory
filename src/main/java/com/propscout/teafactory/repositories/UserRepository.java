package com.propscout.teafactory.repositories;

import com.propscout.teafactory.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByNationalId(Long nationalId);

    Optional<User> findByEmail(String email);
}
