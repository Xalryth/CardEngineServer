/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package EndPoints;

import java.net.URI;
import java.util.Set;

public abstract class ServerEndPoint<T> {
    private int count;
    private Set<T> connections;

    public ServerEndPoint(URI URI){

    }
    public void sstart(){

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
