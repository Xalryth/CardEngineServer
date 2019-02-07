package EndPoints;
/**
 * @author Christoffer Pietras
 * @version 1
 * @since 07-02-2019
 */
public enum ErrorType {
    userExists(0),
    userLoginError(1);


    private int id;

    ErrorType(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}