package m19.core;

import java.io.Serializable;

public class ToStringBook implements Print, Serializable {

    private static final long serialVersionUID = 201901101348L;
    public String toString(Work w){
        Book b = (Book) w;
        String s;
        s = b.getWorkId() + " - " + b.getCurrentCopies() + " de  " + b.getNumberOfCopies() + " - Livro - "
                + b.getTitle() + " - " + b.getPrice() + " - " + b.getCategory().getDescription() + " - " + b.getAuthor()
                + " - " + b.getIsbn() + "\n";
        return s;
    }
}