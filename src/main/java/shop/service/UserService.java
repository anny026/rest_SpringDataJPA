package shop.service;

import shop.model.entity.User;

public interface UserService {

    public String registration(String name, String password) ;

    public User findByLogin(String login);
}
