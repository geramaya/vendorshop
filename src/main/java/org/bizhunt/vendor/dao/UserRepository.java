package org.bizhunt.vendor.dao;

import org.bizhunt.vendor.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
