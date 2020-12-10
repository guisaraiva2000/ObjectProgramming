package m19.core;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.UserRegistrationFailedException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;
import m19.core.exception.MissingFileAssociationException;

import java.io.*;

// FIXME import other system types
// FIXME import other project (core) types

/**
 * The façade class.
 */
public class LibraryManager implements Serializable {

  private static final long serialVersionUID = 201901101348L;

  private Library _library;  // FIXME initialize this attribute
  private String _filename;
  // FIXME define other attributes

  // FIXME define contructor(s)

  public LibraryManager() {
    _library = new Library();
  }


  // FIXME define methods

  public void addUser(String name, String email) throws UserRegistrationFailedException {
     _library.addUser(name, email);
  }

  public User getUser(int id) throws NoSuchUserException {
    return _library.getUser(id);
  }

  public int getUserId(){
    return _library.getUserId();
  }

  public String doShowAllUsers(){
    return _library.doShowAllUsers();
  }

  public String doShowUser(int id) throws NoSuchUserException {
    return _library.doShowUser(id);
  }

  public Library getLibrary(){
    return _library;
  }

  public void setLibrary(Library l){
    _library = l;
  }

  public void setFile(String s){
    _filename = s;
  }

  public String getFile(){
    return _filename;
  }


  public int getCurrentDate(){
    return _library.getCurrentDate();
  }

  public void advanceCurrentDate(int add){
    _library.advanceCurrentDate(add);
  }

  public Work getWork(int id) throws NoSuchWorkException {
    return _library.getWork(id);
  }

  public int getWorkId() throws NoSuchWorkException {
    return _library.getWorkId();
  }

  public String doShowAllWorks(){
    return _library.doShowAllWorks();
  }

  public String doShowWork(int id) throws NoSuchWorkException {
    return _library.doShowWork(id);
  }


  /**
   * Serialize the persistent state of this application.
   * 
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         state has not been set yet.
   * @throws IOException if some error happen during the serialization of the persistent state

   */
  public void save() throws MissingFileAssociationException, IOException {
    // FIXME implement method
    if (_filename == null){
      throw new MissingFileAssociationException();
    }
    ObjectOutputStream o = null;
    try {
      FileOutputStream fos = new FileOutputStream(_filename);
      o = new ObjectOutputStream(fos);
      o.writeObject(_library);
    } finally {
        if( o != null)
          o.close();
    }
  }

  /**
   * Serialize the persistent state of this application into the specified file.
   * 
   * @param filename the name of the target file
   *
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         is not a valid one.
   * @throws IOException if some error happen during the serialization of the persistent state
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    // FIXME implement method
    _filename = filename;
      save();
  }

  /**
   * Recover the previously serialized persitent state of this application.
   * 
   * @param filename the name of the file containing the perssitente state to recover
   *
   * @throws IOException if there is a reading error while processing the file
   * @throws FileNotFoundException if the file does not exist
   * @throws ClassNotFoundException 
   */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    // FIXME implement method
    FileInputStream fis = new FileInputStream(filename);
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
    Library lib = (Library) ois.readObject();
    ois.close();
    _library = lib;
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param datafile the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }
}
