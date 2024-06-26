package com.migrationdemo.user.Mapper;

import com.migrationdemo.user.DTOs.UserEntityDto;
import com.migrationdemo.user.Entity.UserEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity toEntity(UserEntityDto userEntityDto);

    UserEntityDto toDto(UserEntity userEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserEntityDto userEntityDto, @MappingTarget UserEntity userEntity);
}