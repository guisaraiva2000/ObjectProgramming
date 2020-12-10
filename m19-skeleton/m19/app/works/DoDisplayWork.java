package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _workId;

  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    // FIXME initialize input fields
    _workId=_form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    try {
      _form.parse();
      _display.addLine(_receiver.doShowWork(_workId.value()));
      _display.display();
    } catch (DialogException e){
      throw new NoSuchWorkException(_workId.value());
    }
  }

}