package com.revature.dao;

import com.revature.config.ConnectionUtil;
import com.revature.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Set;

public class UserRepository implements CrudRepository<User> {

    @Override
    public User save(User t) {
        String sql = "INSERT INTO app_user ";
        PreparedStatement ps = ConnectionUtil.getInstance().connect().prepareStatement(sql);
        //ps.executeQuery();
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean update(User t) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}