package com.ems.springboot.attendenceservice;

import com.ems.springboot.attendenceentity.Attendence;
import com.ems.springboot.attendencerespository.AttendenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepository attendenceRepository;

    // Get all attendance records
    public List<Attendence> getAllAttendences() {
        return attendenceRepository.findAll();
    }

    // Get attendance record by ID
    public Attendence getAttendenceById(int id) {
        Optional<Attendence> attendence = attendenceRepository.findById(id);
        return attendence.orElse(null);  // Return null if not found
    }

    // Save or update attendance record
    public Attendence saveAttendence(Attendence attendence) {
        return attendenceRepository.save(attendence);
    }

    // Delete attendance record by ID
    public void deleteAttendence(int id) {
        attendenceRepository.deleteById(id);
    }
}
