package shop.service;

import shop.dto.GoodDto;
import shop.model.entity.Good;

import java.util.Map;

public interface GoodService {
    public Map<Long, GoodDto> findAllGoods();

    public Integer findPriceByKey(Integer key);

    public Long findIdByKey(Integer key);

    public GoodDto findIdBy(Long i);
}

