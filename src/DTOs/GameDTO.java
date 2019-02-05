package DTOs;

import java.util.Date;

/*
 * @Author Peter C. Straarup 4/2-2019
 * Game data object used to store scores and general data about the game
 * */

public class GameDTO {
    private long id;
    private GamemodeDTO gamemode;
    private Date created;
    private ScoreDTO[] scores;

    public GameDTO(GamemodeDTO gamemode, ScoreDTO[] scores){
        this.gamemode = gamemode;
        this.scores = scores;
    }

    public GameDTO(int id, GamemodeDTO gamemode, ScoreDTO[] scores, Date created){
        this.id = id;
        this.gamemode = gamemode;
        this.scores = scores;
        this.created = created;
    }

    public long getId(){ return id; }

    public GamemodeDTO getGamemode(){ return gamemode; }

    public void setGamemode(GamemodeDTO gamemode){ this.gamemode = gamemode; }

    public Date getCreated(){ return created; }

    public ScoreDTO[] getScores(){ return scores; }

    public void setScores(ScoreDTO[] scores){ this.scores = scores; }
}
