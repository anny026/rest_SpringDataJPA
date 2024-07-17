package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dto.GoodDto;
import shop.mapper.GoodMapper;
import shop.model.entity.Good;
import shop.repository.GoodRepository;
import shop.service.GoodService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {
    private final GoodRepository repository;
    private final GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodRepository repository, GoodMapper goodMapper) {
        this.repository = repository;
        this.goodMapper = goodMapper;
    }

    public Integer findPriceByKey(Integer key) {
        Optional<Good> good = repository.findById(Long.valueOf(key));
        return (int) repository.findById(Long.valueOf(key)).get().getPrice();
    }

    public Map<Long, GoodDto> findAllGoods() {
        List<Good> goods = (List<Good>) repository.findAll();
        List<GoodDto> goodDto = goodMapper.toDto(goods);
        Map<Long, GoodDto> goodsMap = goodDto.stream()
                .collect(Collectors.toMap(GoodDto::getId, Function.identity()));
        return goodsMap;
    }

    public Long findIdByKey(Integer key) {
        return repository.findById(Long.valueOf(key)).get().getId();
    }

    public GoodDto findIdBy(Long i) {
        return goodMapper.toDto(repository.findById(Long.valueOf(i)).get());
    }

    public List<GoodDto> listAll() {
        return goodMapper.toDto((List<Good>) repository.findAll());
    }
}
