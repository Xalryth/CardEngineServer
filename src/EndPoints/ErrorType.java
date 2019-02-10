package EndPoints;
/**
 * @author Christoffer Pietras
   Difrence error type there can come
 */
public enum ErrorType {
    userExists(0),
    userWrongPassword(1),
    userNotExists(2);

    private int id;

    ErrorType(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}