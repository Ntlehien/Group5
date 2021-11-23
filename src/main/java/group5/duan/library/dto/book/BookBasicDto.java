package group5.duan.library.dto.book;

import lombok.Data;

import java.util.UUID;

@Data
public class BookBasicDto {
    private UUID bookId;
    private String name;
    private String author;
    private Integer quantity;
    private String Url;
    private String type;
    private String detail;
}
