package com.ems.springboot.roleservice;



import com.ems.springboot.roleentity.Role;
import com.ems.springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int role_id) {
        return roleRepository.findById(role_id).orElse(null);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(int role_id) {
        roleRepository.deleteById(role_id);
    }
}
