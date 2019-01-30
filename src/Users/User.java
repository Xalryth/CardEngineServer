package Users;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getname(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
