package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User with id: " + id + " not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete user with id: " + id);
        }

    }

    @Override
    public void update(Integer id, User user) {
        User user1 = userRepository.findById(id).orElseThrow();
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setUserRole(user.getUserRole());
        user1.setPassword(user.getPassword());
        userRepository.save(user1);

    }
}
