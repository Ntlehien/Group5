package group5.duan.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import group5.duan.library.enumration.StatusBorrow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "borrow")
public class BorrowEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "idBorrow", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID borrowId;
    @Column(name= "idUser")
    @Type(type="uuid-char")
    private UUID userId;
    @Column(name= "idBook")
    @Type(type="uuid-char")
    private UUID bookId;
    private Integer quantity;
    @Column(name= "statusBorrow")
    @Enumerated(EnumType.STRING)
    private StatusBorrow statusBorrow;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date date;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date payDate;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idUser", insertable = false, updatable = false)
//    private UserEntity users;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "idBook", insertable = false, updatable = false)
//    private BookEntity book;
}
