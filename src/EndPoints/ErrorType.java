package EndPoints;

public enum ErrorType {
    userExists(0),
    u(1);


    private int id;

    ErrorType(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}