package Users;

/*
 *   @Author Christoffer Pietras
 *   @Date 30-01-2019
 */

import org.glassfish.grizzly.http.server.Session;

public class User extends Session {
    private String username;

    public User(String username){
        this.username = username;
    }


    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
