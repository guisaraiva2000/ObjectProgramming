package m19.core;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.BadEntrySpecificationException;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

// FIXME import other system types
// FIXME import project (core) types if needed

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  // FIXME define attributes
  private int _nextWorkId;
  private int _nextUserId = 0;
  private Date _currentDate;
  private Map <Integer, User> _users;
  private Map <Integer, Work> _works;


  // FIXME define contructor(s)
  public Library(){
    _currentDate = new Date();
    _users = new HashMap<>();
    _works = new HashMap<>();
  }

  // FIXME define methods

  void addUser(String name, String email){
    User u = new User(name, email);
    u.setIsActive(true);
    u.setBehaviour(UserBehaviour.NORMAL);
    u.setId(_nextUserId);
    _users.put(_nextUserId, u);
    _nextUserId++;

  }

  void addBook(String title, String author, int price, Category category, String isbn, int numberOfCopies) {
    Book b = new Book(title, author, price, category, isbn, numberOfCopies);
    b.setWorkId(_nextWorkId);
    _works.put(_nextWorkId, b);
    _nextWorkId++;
  }

  void addDvd(String title, String director, int price, Category category, String igac, int numberOfCopies) {
    Dvd d = new Dvd(title, director, price, category, igac, numberOfCopies);
    d.setWorkId(_nextWorkId);
    _works.put(_nextWorkId, d);
    _nextWorkId++;
  }

  User getUser(int id) throws NoSuchUserException{
    if(_users.containsKey(id)){
      return _users.get(id);
    }
    else {
      throw new NoSuchUserException(id);
    }
  }

  int getUserId(){
    return _nextUserId - 1;
  }

  String doShowUser(int id) throws NoSuchUserException{
    User u = this.getUser(id);
    return u.toStringUser(u);
  }


  String doShowAllUsers(){
    Collection<User> us = _users.values();
    List<User> list = new ArrayList<User>(us);
    String result = "";

    list.sort(Comparator.comparing((User::getId)));
    list.sort(Comparator.comparing(User::getName));

    for(User u : list){
        result = result.concat(u.toStringUser(u));
    }
    return result;
  }

  Work getWork(int id) throws NoSuchWorkException{
    if(_works.containsKey(id)){
      return _works.get(id);
    }
    else {
      throw new NoSuchWorkException(id);
    }
  }

  String doShowAllWorks(){
    Collection<Work> ws = _works.values();
    List<Work> list = new ArrayList<Work>(ws);
    String result = "";

    list.sort(Comparator.comparing(Work::getWorkId));

    for(Work w : list){
      result = result.concat(w.print());
    }
    return result;
  }

  String doShowWork(int id) throws NoSuchWorkException {
    Work w = this.getWork(id);
    return w.print();
  }

  int getWorkId() {
    return _nextWorkId - 1;
  }

  int getCurrentDate(){
    return _currentDate.getCurrentDate();
  }

  void advanceCurrentDate(int add){
    _currentDate.advanceDay(add);
  }


  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
    Parser p = new Parser(this);
    p.parseFile(filename);
  }

}
