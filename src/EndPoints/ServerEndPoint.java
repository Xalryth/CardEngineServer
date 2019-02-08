/**
 * @author Philip Hansen
 * @version 0.1
 * @since 30-01-2019
 */
package EndPoints;


import Users.User;

import java.util.*;

public abstract class ServerEndPoint<T, S> {
    private int count;
    protected Map<T, User> connections;

    public ServerEndPoint() {
        connections = new HashMap<>();
    }

    public abstract void start(S param);

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
