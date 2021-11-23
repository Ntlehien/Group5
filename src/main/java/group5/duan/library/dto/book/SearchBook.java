package group5.duan.library.dto.book;

import lombok.Data;

import java.util.UUID;

@Data
public class SearchBook {
    private UUID bookId;
    private String name;
    private String author;
    private Integer quantity;
    private String Url;
    private String type;
    private String orderBy;
    private Boolean asc;
    public String getSortType() {
        return asc ? "ASC" : "DESC";
    }
}