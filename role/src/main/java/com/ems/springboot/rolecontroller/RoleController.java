package com.ems.springboot.rolecontroller;

import com.ems.springboot.roleentity.Role;
import com.ems.springboot.roleservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles") // Changed to plural for RESTful naming convention
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRole(); // Correct instance method call
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) { // Use 'id' for consistency
        Role role = roleService.getRoleById(id);
        return role != null 
            ? ResponseEntity.ok(role) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@Validated @RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable int id, @Validated @RequestBody Role roleDetails) {
        Role existingRole = roleService.getRoleById(id); // Correct instance method call
        if (existingRole != null) {
            existingRole.setRoleName(roleDetails.getRoleName()); // Ensure proper method names
            existingRole.setDescription(roleDetails.getDescription());
            Role updatedRole = roleService.saveRole(existingRole);
            return ResponseEntity.ok(updatedRole);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        if (roleService.getRoleById(id) != null) {
            roleService.deleteRole(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
