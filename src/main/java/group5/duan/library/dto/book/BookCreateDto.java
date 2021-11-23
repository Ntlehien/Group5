package group5.duan.library.dto.book;

import lombok.Data;

@Data
public class BookCreateDto {
    private String name;
    private String author;
    private Integer quantity;
    private String type;
    private String Url;
    private String detail;
}
