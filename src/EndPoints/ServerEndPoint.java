/**
 * @author Philip Hansen
 * @version 0.1
 * @since 30-01-2019
 */
package EndPoints;

import org.glassfish.grizzly.http.server.Session;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ServerEndPoint<T, S> {
    private int count;
    protected Set<T> connections;

    public ServerEndPoint() {
        connections = new HashSet<T>();
    }

    public abstract void start(S param);

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
