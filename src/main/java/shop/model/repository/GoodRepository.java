package shop.model.repository;

import org.springframework.data.repository.CrudRepository;
import shop.model.entity.Good;
import shop.model.entity.User;

public interface GoodRepository extends CrudRepository<Good, Long> {

}
