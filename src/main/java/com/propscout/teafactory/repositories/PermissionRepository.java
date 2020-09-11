package com.propscout.teafactory.repositories;

import com.propscout.teafactory.models.entities.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Integer> {
}
