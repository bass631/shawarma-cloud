package ru.shawarmacloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shawarmacloud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
