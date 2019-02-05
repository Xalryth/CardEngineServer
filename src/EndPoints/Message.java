package EndPoints;


import javax.websocket.Session;

public class Message<T> {
    Session from;
    Session to;
    T message;

    public void setFrom(Session from) {
        this.from = from;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public void setTo(Session to) {
        this.to = to;
    }

    public Session getFrom() {
        return from;
    }

    public Session getTo() {
        return to;
    }

    public T getMessage() {
        return message;
    }
}

