package be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.dto.BaptismalSong;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.entity.BaptismalSongEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaptismalSongMapper {
    BaptismalSongEntity toEntity(BaptismalSong dto);

    BaptismalSong toDto(BaptismalSongEntity entity);

}
