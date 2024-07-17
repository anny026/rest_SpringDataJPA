package shop.service;

import shop.dto.UserDto;
import shop.model.entity.User;

public interface UserService {

    public String registration(String name, String password) ;

    public UserDto findByLogin(String login);
}
