package DTOs;

/*
 * @Author Peter C. Straarup 4/2-2019
 * Ruleset data object used for storing the id, name and root gamemode of
 * a specific ruleset.
 * */

public class RulesetDTO {
    private int id;
    private String name;
    private GamemodeDTO gamemode;

    public RulesetDTO(String name, String gamemmodeName){
        this.name = name;
        this.gamemode = new GamemodeDTO(gamemmodeName);
    }

    public RulesetDTO(int id, String name, GamemodeDTO gamemode){
        this.id = id;
        this.name = name;
        this.gamemode = gamemode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamemodeDTO getGamemode() {
        return gamemode;
    }

    public void setGamemode(GamemodeDTO gamemode) {
        this.gamemode = gamemode;
    }
}
