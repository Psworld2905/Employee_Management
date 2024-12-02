package com.ems.springboot.repository;

import com.ems.springboot.roleentity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Custom query methods (if any) can be added here
}