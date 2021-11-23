package group5.duan.library.mapper;

import group5.duan.library.dto.borrow.BorrowBasicDto;
import group5.duan.library.dto.borrow.BorrowCreateDto;
import group5.duan.library.entity.BorrowEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBorrowMapper {
    List<BorrowBasicDto> toBasicDtos(List<BorrowEntity> borrow);
    BorrowEntity fromCreateToEntity(BorrowCreateDto borrow);
    BorrowBasicDto toBasicDto(BorrowEntity returnBorrow);
    BorrowEntity fromBasicToEntity(BorrowBasicDto borrow);
}
