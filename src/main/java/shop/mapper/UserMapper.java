package shop.mapper;

import org.mapstruct.Mapper;
import shop.dto.OrderDto;
import shop.dto.UserDto;
import shop.model.entity.Order;
import shop.model.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public UserDto toDto(User user);
    public User fromDto(UserDto userDto);
    public List<UserDto> toDto(List<User> users);
}
