package group5.duan.library.mapper;

import group5.duan.library.dto.book.BookBasicDto;
import group5.duan.library.dto.book.BookCreateDto;
import group5.duan.library.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface IBookMapper {
    List<BookBasicDto> toBasicDtos(List<BookEntity> books);
    BookEntity fromCreateToEntity(BookCreateDto book);
    BookBasicDto toBasicDto(BookEntity returnBook);
    BookEntity fromBasicToEntity(BookBasicDto book);
}
