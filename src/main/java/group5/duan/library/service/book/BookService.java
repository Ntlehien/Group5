package group5.duan.library.service.book;

import group5.duan.library.dto.book.BookBasicDto;
import group5.duan.library.dto.book.BookCreateDto;
import group5.duan.library.entity.BookEntity;
import group5.duan.library.mapper.IBookMapper;
import group5.duan.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookService implements IBookService {
    private final BookRepository bookRepo;
    private final IBookMapper bookMapper;

    public BookService(BookRepository bookRepo, IBookMapper bookMapper) {
        this.bookRepo = bookRepo;
        this.bookMapper = bookMapper;
    }

    public List<BookBasicDto> listAll() {
        List<BookEntity> books = bookRepo.findAll();
        if (books.size() > 0) {
            return bookMapper.toBasicDtos(books);
        }
        return new ArrayList<>();
    }

    public BookBasicDto createBook(BookCreateDto book) {
        BookEntity bookEntity = bookMapper.fromCreateToEntity(book);
        BookEntity returnBook = bookRepo.save(bookEntity);
        return bookMapper.toBasicDto(returnBook);
    }

    public BookBasicDto getById(UUID BookId) {
        BookEntity bookEntity = bookRepo.findFirstByBookId(BookId);
        if (bookEntity != null) {
            return bookMapper.toBasicDto(bookEntity);
        }
        return null;
    }

    public boolean delete(UUID BookId) {
        BookEntity bookEntity = bookRepo.findFirstByBookId(BookId);
        if (bookEntity != null) {
            bookRepo.deleteByBookId(BookId);
            return true;
        }
        return false;
    }

    public BookBasicDto updateBook(BookBasicDto book, UUID bookId) {
        BookEntity oldBook = bookRepo.findFirstByBookId(bookId);
        BookEntity bookEntity = bookMapper.fromBasicToEntity(book);
        BookEntity returnBook = bookRepo.saveAndFlush(bookEntity);
        return bookMapper.toBasicDto(returnBook);
    }

    public List<BookBasicDto> searchBook(String name) {
        System.out.println(name);
        if (StringUtils.hasText(name)) {
            List<BookEntity> books = bookRepo.findAllByNameContaining(name);
            if (books.size() > 0)
                return bookMapper.toBasicDtos(books);
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
//    public boolean updateBorrow(UUID BookId){
//
//    }
}
