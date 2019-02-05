package DTOs;

/*
 * @Author Peter C. Straarup 4/2-2019
 * Gamemode data object used to store the id and name of the specific gamemode
 * */

public class GamemodeDTO {
    private int id;
    private String name;

    public GamemodeDTO(String name){
        this.name = name;
    }

    public GamemodeDTO(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
