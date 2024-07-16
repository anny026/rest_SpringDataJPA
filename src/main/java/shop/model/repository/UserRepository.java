package shop.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import shop.model.entity.User;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("from User u where u.username=:username")
    User findByLogin(@Param("username") String username);
}
