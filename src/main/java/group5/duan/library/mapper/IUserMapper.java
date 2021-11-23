package group5.duan.library.mapper;

import group5.duan.library.dto.user.UserBasicDto;
import group5.duan.library.dto.user.UserCreateDto;
import group5.duan.library.dto.user.UserInfoDto;
import group5.duan.library.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserBasicDto toBasicDto(UserEntity returnUser);
    List<UserBasicDto> toBasicDtos(List<UserEntity> users);
    UserEntity fromBasicToEntity(UserBasicDto user);
    UserInfoDto toInfoDto(UserEntity userEntity);
    UserEntity fromCreateToEntity(UserCreateDto user);
}
