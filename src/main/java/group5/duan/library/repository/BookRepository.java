package group5.duan.library.repository;

import group5.duan.library.dto.book.BookBasicDto;
import group5.duan.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository <BookEntity, UUID>{
    BookEntity findFirstByBookId(UUID bookId);
    boolean deleteByBookId(UUID bookId);

    List<BookEntity> findAllByNameContaining(String name);
}
