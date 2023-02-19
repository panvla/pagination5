package com.vladimirpandurov.pagination5B.service;

import com.vladimirpandurov.pagination5B.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
