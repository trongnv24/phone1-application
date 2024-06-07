package Aibles_Training_java.Spring.boot.phone1.repository;

import Aibles_Training_java.Spring.boot.phone1.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
}
