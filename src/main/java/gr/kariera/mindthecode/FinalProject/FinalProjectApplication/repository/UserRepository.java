package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
