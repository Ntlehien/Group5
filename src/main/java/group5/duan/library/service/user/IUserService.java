package group5.duan.library.service.user;


import group5.duan.library.dto.AuthenticationRequestDto;
import group5.duan.library.dto.user.UserBasicDto;
import group5.duan.library.dto.user.UserCreateDto;
import group5.duan.library.dto.user.UserInfoDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserBasicDto> listAll();
    UserBasicDto getById(UUID UserId);
    UserInfoDto login(AuthenticationRequestDto authenticationRequestDto);
    UserDetails loadUserByUsername(String userName);
    UserBasicDto createUser(UserCreateDto user);
    UserBasicDto updateUser(UserBasicDto user, UUID UserId);
    boolean delete(UUID UserId);
}
