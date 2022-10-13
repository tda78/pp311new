package com.example.demo.service;

import com.example.demo.repository.UserCrudRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserCrudRepository repository;

    public UserCrudRepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(UserCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> readUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User getUser(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
