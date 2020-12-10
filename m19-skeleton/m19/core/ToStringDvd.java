package m19.core;

import java.io.Serializable;

public class ToStringDvd implements Print, Serializable {

    private static final long serialVersionUID = 201901101348L;

    public String toString(Work w){
        Dvd d = (Dvd) w;
        String s;
        s = d.getWorkId() + " - " + d.getCurrentCopies() + " de  " + d.getNumberOfCopies() + " - DVD - "
                + d.getTitle() + " - " + d.getPrice() + " - " + d.getCategory().getDescription()+ " - " + d.getDirector()
                + " - " + d.getIgac() + "\n";
        return s;
    }
}