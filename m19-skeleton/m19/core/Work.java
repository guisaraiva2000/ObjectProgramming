package m19.core;

public abstract class Work implements java.io.Serializable {

    private static final long serialVersionUID = 201901101348L;

    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _currentCopies;
    private String _title;
    private Category _category;

    public Work(String title, int price, Category category, int copies) {

        _title = title;
        _price = price;
        _currentCopies = copies;
        _numberOfCopies = copies;
        _category = category;
    }

    int getWorkId() {
        return _id;
    }

    void setWorkId(int id) {
        _id = id;
    }

    int getNumberOfCopies() {
        return _numberOfCopies;
    }

    int getCurrentCopies() {
        return _currentCopies;
    }

    int getPrice() {
        return _price;
    }

    String getTitle() {
        return _title;
    }

    Category getCategory() {
        return _category;
    }

    abstract String print();
}
