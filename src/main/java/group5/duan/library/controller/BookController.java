package group5.duan.library.controller;

import group5.duan.library.dto.book.BookBasicDto;
import group5.duan.library.dto.book.BookCreateDto;
import group5.duan.library.service.book.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookBasicDto>> list() {
        try {
            List<BookBasicDto> book = bookService.listAll();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{BookId}")
    public ResponseEntity<BookBasicDto> get(@PathVariable UUID BookId) {
        try {
            BookBasicDto book = bookService.getById(BookId);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/book")
    public ResponseEntity<BookBasicDto> create(@RequestBody BookCreateDto newBook) {
        try {
            BookBasicDto bookReturn = bookService.createBook(newBook);
            return new ResponseEntity<>(bookReturn, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/book/{BookId}")
    public ResponseEntity<BookBasicDto> update(@RequestBody BookBasicDto book, @PathVariable UUID BookId) {
        try {
            BookBasicDto bookDto = bookService.updateBook(book, BookId);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{BookId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID BookId) {
        try {
            bookService.delete(BookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books-search")
    public ResponseEntity<List<BookBasicDto>> filterBook(@RequestParam(value = "keyword") String name) {
        try {
            List<BookBasicDto> books = bookService.searchBook(name);
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
