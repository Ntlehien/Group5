package group5.duan.library.service.book;

import group5.duan.library.dto.book.BookBasicDto;
import group5.duan.library.dto.book.BookCreateDto;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    List<BookBasicDto> listAll();
    boolean delete(UUID bookId);
    BookBasicDto createBook(BookCreateDto newBook);
    BookBasicDto getById(UUID bookId);
    BookBasicDto updateBook(BookBasicDto book, UUID bookId);

    List<BookBasicDto> searchBook(String name);
}
