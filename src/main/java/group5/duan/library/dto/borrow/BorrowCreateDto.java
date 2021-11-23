package group5.duan.library.dto.borrow;

import group5.duan.library.entity.UserEntity;
import group5.duan.library.enumration.StatusBorrow;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;
@Data
public class BorrowCreateDto {
    private UUID userId;
    @Enumerated(EnumType.STRING)
    private StatusBorrow statusBorrow;
    private Date date;
    private UUID bookId;
    private UserEntity user;
    private String Url;
    private String type;
    private String detail;
}
