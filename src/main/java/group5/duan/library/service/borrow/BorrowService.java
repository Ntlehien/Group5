package group5.duan.library.service.borrow;

import group5.duan.library.dto.borrow.BorrowBasicDto;
import group5.duan.library.dto.borrow.BorrowCreateDto;
import group5.duan.library.entity.BookEntity;
import group5.duan.library.entity.BorrowEntity;
import group5.duan.library.mapper.IBorrowMapper;
import group5.duan.library.repository.BorrowRepository;
import group5.duan.library.service.book.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BorrowService implements IBorrowService {
    private final BorrowRepository borrowRepo;
    private final IBorrowMapper borrowMapper;
    private final BookService bookService;

    public BorrowService(BorrowRepository borrowRepo, IBorrowMapper borrowMapper, BookService bookService) {
        this.borrowRepo = borrowRepo;
        this.borrowMapper = borrowMapper;
        this.bookService = bookService;
    }

    public List<BorrowBasicDto> listAll() {
        List<BorrowEntity> borrow = borrowRepo.findAll();
        if (borrow.size() > 0) {
            return borrowMapper.toBasicDtos(borrow);
        }
        return new ArrayList<>();
    }

    public BorrowBasicDto createBorrow(BorrowCreateDto borrow) {
        borrow.setDate(new Date());
        BorrowEntity borrowEntity = borrowMapper.fromCreateToEntity(borrow);
        BorrowEntity returnBorrow = borrowRepo.save(borrowEntity);
        return borrowMapper.toBasicDto(returnBorrow);

    }

    public BorrowBasicDto getById(UUID BorrowId) {
        BorrowEntity borrowEntity = borrowRepo.findFirstByBorrowId(BorrowId);
        if (borrowEntity != null) {
            return borrowMapper.toBasicDto(borrowEntity);
        }
        return null;
    }

    public boolean delete(UUID BorrowId) {
        BorrowEntity borrowEntity = borrowRepo.findFirstByBorrowId(BorrowId);
        if (borrowEntity != null) {
            borrowRepo.deleteByBorrowId(BorrowId);
            return true;
        }
        return false;
    }

    public BorrowBasicDto updateBorrow(BorrowBasicDto borrow, UUID borrowId) {
        borrow.setDate(new Date());
        BorrowEntity oldBorrow = borrowRepo.findFirstByBorrowId(borrowId);
        BorrowEntity borrowEntity = borrowMapper.fromBasicToEntity(borrow);
        BorrowEntity returnBorrow = borrowRepo.saveAndFlush(borrowEntity);
        return borrowMapper.toBasicDto(returnBorrow);
    }
}

