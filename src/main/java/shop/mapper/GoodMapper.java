package shop.mapper;


import org.mapstruct.Mapper;
import shop.dto.GoodDto;
import shop.model.entity.Good;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodMapper {
    public GoodDto toDto(Good good);
    public Good fromDto(GoodDto goodDto);
    public List<GoodDto> toDto(List<Good> goods);
}
