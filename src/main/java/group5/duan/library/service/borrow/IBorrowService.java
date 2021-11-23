package group5.duan.library.service.borrow;

import group5.duan.library.dto.borrow.BorrowBasicDto;
import group5.duan.library.dto.borrow.BorrowCreateDto;

import java.util.List;
import java.util.UUID;

public interface IBorrowService {
    List<BorrowBasicDto> listAll();
    BorrowBasicDto getById(UUID borrowId);
    BorrowBasicDto createBorrow(BorrowCreateDto newBorrow);
    BorrowBasicDto updateBorrow(BorrowBasicDto borrow, UUID borrowId);
}
