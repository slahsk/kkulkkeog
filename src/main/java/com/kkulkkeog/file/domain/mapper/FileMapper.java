package com.kkulkkeog.file.domain.mapper;

import com.kkulkkeog.file.api.web.PostFileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

}
