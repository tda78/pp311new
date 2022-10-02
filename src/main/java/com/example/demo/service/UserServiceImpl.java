package com.example.demo.service;

import com.example.demo.dao.UserCrudRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserCrudRepository dao;

    public UserCrudRepository getDao() {
        return dao;
    }
    @Autowired
    public void setDao(UserCrudRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<User> readUsers() {
        return (List<User>) dao.findAll();
    }

    @Override
    public User getUser(long id) {
        return dao.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    @Override
    public void updateUser(User user) {
        dao.save(user);
    }

    @Override
    public void deleteUser(long id) {
        dao.deleteById(id);
    }
}
