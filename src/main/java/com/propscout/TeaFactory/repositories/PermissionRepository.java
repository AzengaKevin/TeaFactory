package com.propscout.TeaFactory.repositories;

import com.propscout.TeaFactory.models.entities.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Integer> {
}
