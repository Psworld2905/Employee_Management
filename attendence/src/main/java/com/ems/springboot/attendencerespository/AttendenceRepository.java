package com.ems.springboot.attendencerespository;

import com.ems.springboot.attendenceentity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Integer> {
    // Custom query methods for attendance (if any) can be added here
}
