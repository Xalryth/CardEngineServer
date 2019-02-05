package EndPoints;

public enum Type {
    CreateUser(0),
    UpdateUser(1),
    DeleteUser( 2),
    UserResetPassword(3),

    UserLogin(50),

    //Lobby 100
    CreateRoom (100),
    RemoveRoom (101),
    LeaveRoom (102),
    JoinRoom (103),
    Ready (104),
    UnReady (105),


    //Game 200
    JoinGame (200),
    LeaveGame (201),
    KickPlayer (202),


    //Round 300
    DealCard (300),
    PlayCard (301),
    DrawCard (302),
    ThrowCard (303),
    EndGame (304),
    EndRound (305),
    EndTurn (306),
    NextTurn (307);
    //Specific 1000


    private int id;

    Type(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
