package me.dio.santanderdevweek2023.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santanderdevweek2023.domain.model.User;
import me.dio.santanderdevweek2023.domain.repository.UserRepository;
import me.dio.santanderdevweek2023.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToBeCreated) {
        if (userRepository.existsByAccountNumber(userToBeCreated.getAccount().getNumber())) {
            throw new IllegalArgumentException("The user with this account number already exists");
        }
        return userRepository.save(userToBeCreated);
    }
}
