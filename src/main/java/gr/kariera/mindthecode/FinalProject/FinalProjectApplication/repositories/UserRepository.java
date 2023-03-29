package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repositories;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}