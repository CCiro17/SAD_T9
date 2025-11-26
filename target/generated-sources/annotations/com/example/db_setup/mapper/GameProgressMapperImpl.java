package com.example.db_setup.mapper;

import com.example.db_setup.model.GameProgress;
import com.example.db_setup.model.Opponent;
import com.example.db_setup.model.dto.gamification.GameProgressDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import testrobotchallenge.commons.models.opponent.GameMode;
import testrobotchallenge.commons.models.opponent.OpponentDifficulty;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T11:18:35+0100",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class GameProgressMapperImpl implements GameProgressMapper {

    @Override
    public GameProgressDTO gameProgressToGameProgressDTO(GameProgress gameProgress) {
        if ( gameProgress == null ) {
            return null;
        }

        GameProgressDTO gameProgressDTO = new GameProgressDTO();

        gameProgressDTO.setWon( gameProgress.isWinner() );
        gameProgressDTO.setGameMode( gameProgressOpponentGameMode( gameProgress ) );
        gameProgressDTO.setClassUT( gameProgressOpponentClassUT( gameProgress ) );
        gameProgressDTO.setType( gameProgressOpponentType( gameProgress ) );
        gameProgressDTO.setDifficulty( gameProgressOpponentDifficulty( gameProgress ) );
        Set<String> set = gameProgress.getAchievements();
        if ( set != null ) {
            gameProgressDTO.setAchievements( new LinkedHashSet<String>( set ) );
        }

        return gameProgressDTO;
    }

    @Override
    public List<GameProgressDTO> gameProgressToGameProgressDTOList(List<GameProgress> gameProgresses) {
        if ( gameProgresses == null ) {
            return null;
        }

        List<GameProgressDTO> list = new ArrayList<GameProgressDTO>( gameProgresses.size() );
        for ( GameProgress gameProgress : gameProgresses ) {
            list.add( gameProgressToGameProgressDTO( gameProgress ) );
        }

        return list;
    }

    private GameMode gameProgressOpponentGameMode(GameProgress gameProgress) {
        Opponent opponent = gameProgress.getOpponent();
        if ( opponent == null ) {
            return null;
        }
        return opponent.getGameMode();
    }

    private String gameProgressOpponentClassUT(GameProgress gameProgress) {
        Opponent opponent = gameProgress.getOpponent();
        if ( opponent == null ) {
            return null;
        }
        return opponent.getClassUT();
    }

    private String gameProgressOpponentType(GameProgress gameProgress) {
        Opponent opponent = gameProgress.getOpponent();
        if ( opponent == null ) {
            return null;
        }
        return opponent.getType();
    }

    private OpponentDifficulty gameProgressOpponentDifficulty(GameProgress gameProgress) {
        Opponent opponent = gameProgress.getOpponent();
        if ( opponent == null ) {
            return null;
        }
        return opponent.getDifficulty();
    }
}
