package com.example.db_setup.mapper;

import com.example.db_setup.model.PlayerProgress;
import com.example.db_setup.model.dto.gamification.PlayerProgressDTO;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T11:18:34+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class PlayerProgressMapperImpl implements PlayerProgressMapper {

    @Autowired
    private GameProgressMapper gameProgressMapper;

    @Override
    public PlayerProgressDTO playerProgressToPlayerProgressDTO(PlayerProgress playerProgress) {
        if ( playerProgress == null ) {
            return null;
        }

        PlayerProgressDTO playerProgressDTO = new PlayerProgressDTO();

        playerProgressDTO.setGameProgressesDTO( gameProgressMapper.gameProgressToGameProgressDTOList( playerProgress.getProgresses() ) );
        playerProgressDTO.setExperiencePoints( playerProgress.getExperiencePoints() );
        Set<String> set = playerProgress.getGlobalAchievements();
        if ( set != null ) {
            playerProgressDTO.setGlobalAchievements( new LinkedHashSet<String>( set ) );
        }

        return playerProgressDTO;
    }
}
