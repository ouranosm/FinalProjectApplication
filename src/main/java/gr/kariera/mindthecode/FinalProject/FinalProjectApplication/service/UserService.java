package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;


import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User getById(Integer id);

    List<User> getAll();

    void deleteById(Integer id);

    void update(Integer id, User user);
}
