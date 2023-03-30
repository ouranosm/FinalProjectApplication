package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;

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
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Integer id, User user) {

    }
}
