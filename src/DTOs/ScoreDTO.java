package DTOs;

/*
* @Author Peter C. Straarup 4/2-2019
* Score data class for storing the score of a user within
* a specific game, providing data such as points, whether the user
* left early, as well as whether the user won the game.
* */

public class ScoreDTO {
    private UserDTO user;
    private short points;
    private Boolean win;
    private Boolean left;

    public ScoreDTO(UserDTO user, short points, boolean won, boolean left){
        this.user = user;
        this.points = points;
        this.win = won;
        this.left = left;
    }

    public UserDTO getUser() {
        return user;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Boolean getLeft() {
        return left;
    }

    public void setLeft(Boolean left) {
        this.left = left;
    }
}
