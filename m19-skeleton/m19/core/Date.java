package m19.core;

public class Date implements java.io.Serializable {

    private static final long serialVersionUID = 201901101348L;

    private int _currentDate;

    public Date(){
        _currentDate = 0;
    }

    int getCurrentDate(){
        return _currentDate;
    }

    void advanceDay(int add){
        _currentDate += add;
    }
}
