package com.vladimirpandurov.pagination5B.service.implementationSDJPA;

import com.vladimirpandurov.pagination5B.model.User;
import com.vladimirpandurov.pagination5B.repository.UserRepository;
import com.vladimirpandurov.pagination5B.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceSpringDataJPA implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }
}
