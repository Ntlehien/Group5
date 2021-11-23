package group5.duan.library.controller;

import group5.duan.library.dto.borrow.BorrowBasicDto;
import group5.duan.library.dto.borrow.BorrowCreateDto;
import group5.duan.library.service.borrow.IBorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class BorrowController {
    private final IBorrowService borrowService;

    public BorrowController(IBorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/borrow")
    public ResponseEntity<List<BorrowBasicDto>> list() {
        try {
            List<BorrowBasicDto> borrow = borrowService.listAll();
            return new ResponseEntity<>(borrow, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/borrow/{BorrowId}")
    public ResponseEntity<BorrowBasicDto> get(@PathVariable UUID BorrowId) {
        try {
            BorrowBasicDto borrow = borrowService.getById(BorrowId);
            return new ResponseEntity<>(borrow, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowBasicDto> create(@RequestBody BorrowCreateDto newBorrow) {
        try {
            BorrowBasicDto borrowReturn = borrowService.createBorrow(newBorrow);
            return new ResponseEntity<>(borrowReturn, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/borrow/{BorrowId}")
    public ResponseEntity<BorrowBasicDto> update(@RequestBody BorrowBasicDto borrow, @PathVariable UUID BorrowId) {
        try {
            BorrowBasicDto borrowDto = borrowService.updateBorrow(borrow, BorrowId);
            return new ResponseEntity<>(borrowDto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

