package EndPoints;
/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */
public enum PacketType {
    CreateUser(0),
    UpdateUser(1),
    RemoveUser( 2),
    ResetPasswordUser(3),

    UserLogin(50),

    //Lobby 100
    CreateLobby (100),
    RemoveLobby (101),
    LeaveLobby (102),
    JoinLobby (103),
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
    NextTurn (307),

    //Error 400
    Error ( 400);

    private int id;

    PacketType(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}