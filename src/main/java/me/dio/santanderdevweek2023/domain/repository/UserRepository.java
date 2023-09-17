package me.dio.santanderdevweek2023.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.santanderdevweek2023.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {    
}
