package shop.repository;

import org.springframework.data.repository.CrudRepository;
import shop.model.entity.Good;

public interface GoodRepository extends CrudRepository<Good, Long> {

}
