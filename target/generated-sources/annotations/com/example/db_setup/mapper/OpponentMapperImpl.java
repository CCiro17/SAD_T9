package com.example.db_setup.mapper;

import com.example.db_setup.model.Opponent;
import com.example.db_setup.model.dto.gamification.OpponentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T11:18:35+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class OpponentMapperImpl implements OpponentMapper {

    @Override
    public OpponentDTO opponentToOpponentDTO(Opponent opponent) {
        if ( opponent == null ) {
            return null;
        }

        OpponentDTO opponentDTO = new OpponentDTO();

        opponentDTO.setClassUT( opponent.getClassUT() );
        opponentDTO.setType( opponent.getType() );
        opponentDTO.setDifficulty( opponent.getDifficulty() );
        opponentDTO.setGameMode( opponent.getGameMode() );

        return opponentDTO;
    }
}
