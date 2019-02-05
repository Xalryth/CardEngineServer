package Users;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

import org.glassfish.grizzly.http.server.Session;

public class User extends Session {
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
