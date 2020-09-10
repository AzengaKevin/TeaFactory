package com.propscout.TeaFactory;

import com.propscout.TeaFactory.models.entities.Permission;
import com.propscout.TeaFactory.models.entities.Role;
import com.propscout.TeaFactory.repositories.PermissionRepository;
import com.propscout.TeaFactory.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TeaFactoryApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public static void main(String[] args) {
        SpringApplication.run(TeaFactoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role role = new Role("Admin", "The top most role in the application");

        Arrays.stream(new String[]{"view_centers", "view_schedule", "edit_schedule"})
                .map(Permission::new)
                .forEach(permissionRepository::save);

        roleRepository.save(role);
    }
}
