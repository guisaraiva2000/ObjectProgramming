package m19.core;

public class Book extends Work implements java.io.Serializable  {
    private static final long serialVersionUID = 201901101348L;
    private String _author;
    private String _isbn;

    public Book(String title, String author, int price, Category category, String isbn, int numberOfCopies) {
        super(title, price, category, numberOfCopies);
        _author = author;
        _isbn = isbn;
    }

    String getAuthor(){
        return _author;
    }
    String getIsbn(){
        return _isbn;
    }
    String print(){
        Print b = new ToStringBook();
        return b.toString(this);
    }

}