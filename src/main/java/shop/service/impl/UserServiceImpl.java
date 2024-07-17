package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.UserDto;
import shop.mapper.UserMapper;
import shop.model.entity.User;
import shop.repository.UserRepository;
import shop.service.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private final UserRepository repository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public String registration(String name, String password) {
        User findUser = repository.findByLogin(name);
        logger.log(Level.INFO, "Регистрация" + findUser);
        if (findUser == null) {
            repository.save(new User(name, password));
            return "life is beautiful";
        } else {
            logger.log(Level.INFO, "Логин существует");
            return "this login is not available";
        }
    }

    public UserDto findByLogin(String login) {
        UserDto user = userMapper.toDto(repository.findByLogin(login));
        logger.log(Level.INFO, "UserServiceImpl findByLogin ");
        return user;
    }
}
