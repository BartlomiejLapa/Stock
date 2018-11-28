package com.bartlap.stock.loginpage.service;

import com.bartlap.stock.loginpage.model.User;

public interface UserService {
    
    public User findUserByEmail(String email);
    
    public void saveUser(User user);    
}
