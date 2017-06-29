package ru.itpark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
