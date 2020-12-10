package m19.core;

public class Notification implements java.io.Serializable{
    private static final long serialVersionUID = 201901101348L;

    private String _notification;

    public Notification() {
    }

    String getNotification() {
        return _notification;
    }

    void setNotification(String message) {
        _notification = message;
    }
}