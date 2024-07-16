package shop.service;

import shop.model.entity.Good;

import java.util.Map;

public interface GoodService {
    public Map<Integer, Good> findAllGoods();
    public Integer findPriceByKey(Integer key);

    public Long findIdByKey(Integer key);

    public Good findIdBy(Long i);
}

