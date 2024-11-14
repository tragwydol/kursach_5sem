package com.example.demo.repositories;

        import com.example.demo.entities.Enrollment;
        import com.example.demo.entities.EnrollmentStatus;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByStatus(EnrollmentStatus status);
    List<Enrollment> findByUserId(Integer userId);

}
