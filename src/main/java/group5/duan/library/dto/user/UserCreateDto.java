package group5.duan.library.dto.user;

import group5.duan.library.enumration.UserRole;
import lombok.Data;

import java.util.Date;

@Data
public class UserCreateDto {
    private String userName;
    private String password;
    private String name;
    private String address;
    private String phone;
    private Date birthDate;
    private boolean gender;
    private UserRole role;
}
