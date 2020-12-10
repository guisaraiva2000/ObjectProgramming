package m19.core;

public class Dvd extends Work implements java.io.Serializable  {
    private static final long serialVersionUID = 201901101348L;
    private String _director;
    private String _igac;
    private int _type=1;

    public Dvd(String title, String director, int price, Category category, String igac, int numberOfCopies) {
        super(title, price, category, numberOfCopies);
        _director = director;
        _igac = igac;
    }

    String getDirector(){
        return _director;
    }
    String getIgac(){
        return _igac;
    }
    String print(){
        Print d = new ToStringDvd();
        return d.toString(this);
    }

}