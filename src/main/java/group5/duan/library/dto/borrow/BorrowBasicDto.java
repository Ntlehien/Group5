package group5.duan.library.dto.borrow;

import com.fasterxml.jackson.annotation.JsonFormat;
import group5.duan.library.entity.BookEntity;
import group5.duan.library.entity.UserEntity;
import group5.duan.library.enumration.StatusBorrow;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;

@Data
public class BorrowBasicDto {
    private UUID borrowId;
    private UUID userId;
    @Enumerated(EnumType.STRING)
    private StatusBorrow statusBorrow;
    private UUID bookId;
    private Integer quantity;
    @Column(name = "date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Date payDate;
//    private UserEntity users;
    private BookEntity book;
}
