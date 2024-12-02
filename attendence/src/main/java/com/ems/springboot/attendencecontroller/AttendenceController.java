package com.ems.springboot.attendencecontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ems.springboot.attendenceentity.Attendence;
import com.ems.springboot.attendenceservice.AttendenceService;

@RestController
@RequestMapping("/api/attendence")
public class AttendenceController {

    @Autowired
    private AttendenceService attendenceService;

    @GetMapping
    public List<Attendence> getAllAttendences() {
        return attendenceService.getAllAttendences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendence> getAttendenceById(@PathVariable int id) {
        Attendence attendence = attendenceService.getAttendenceById(id);
        return attendence != null 
            ? ResponseEntity.ok(attendence) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Attendence> createAttendence(@Validated @RequestBody Attendence attendence) {
        Attendence savedAttendence = attendenceService.saveAttendence(attendence);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAttendence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendence> updateAttendence(
        @PathVariable int id, 
        @Validated @RequestBody Attendence attendenceDetails) {
        
        Attendence existingAttendence = attendenceService.getAttendenceById(id);
        if (existingAttendence != null) {
            // Update fields
            existingAttendence.setDepartmentName(attendenceDetails.getDepartmentName());
            existingAttendence.setLocation(attendenceDetails.getLocation());
            Attendence updatedAttendence = attendenceService.saveAttendence(existingAttendence);
            return ResponseEntity.ok(updatedAttendence);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendence(@PathVariable int id) {
        Attendence attendence = attendenceService.getAttendenceById(id);
        if (attendence != null) {
            attendenceService.deleteAttendence(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
