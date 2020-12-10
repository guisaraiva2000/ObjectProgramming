package m19.core;

import java.util.ArrayList;
import java.util.Iterator;

public class User implements java.io.Serializable{

    private static final long serialVersionUID = 201901101348L;

    private int _id;
    private int _fine;
    private boolean _isActive;
    private String _name;
    private String _email;
    private UserBehaviour _behaviour;
    private ArrayList <Notification> _notifications = new ArrayList<>();

    public User(String name, String email){
        _name = name;
        _email = email;
    }

    void setId(int id){
        _id = id;
    }

    void setBehaviour(UserBehaviour b){
        _behaviour = b;
    }

    void setIsActive(boolean active){
        _isActive = active;
    }
    boolean isActive(){
        return _isActive;
    }

    int getId(){
        return _id;
    }

    String getEmail() {
        return _email;
    }

    String getName() {
        return _name;
    }

    int getFine(){
        return _fine;
    }

    UserBehaviour getBehaviour(){
        return _behaviour;
    }

    void changeBehaviour(UserBehaviour b){
        _behaviour = b;
    }

    void addNotification(Notification n){
        _notifications.add(n);
    }

    void setFine(int f){
        _fine = f;
    }

    String showNotifications(){
        StringBuilder output = new StringBuilder();

        for(Notification n: _notifications){
            output.append(n.getNotification());
            output.append("\n");
        }

        return output.toString();
    }

    void deleteNotifications(){
        Iterator<Notification> iter = _notifications.iterator();

        while(iter.hasNext()){
            iter.remove();
        }
    }

    public String toStringUser(User u){
        String s;
        if(u.isActive()) {
            s = u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - "
                    + u.getBehaviour() + " - " + "ACTIVO\n";
        }
        else {
            if (u.getFine() == 0) {
                s = u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - "
                        + u.getBehaviour() + " - " + "SUSPENSO\n";
            }
            else {
                s = u.getId() + " - " + u.getName() + " - " + u.getEmail() + " - "
                        + u.getBehaviour() + " - " + "SUSPENSO" + " - EUR " + u.getFine() + "\n";
            }
        }
        return s;
    }

}