package m19.app.works;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
// FIXME import other core concepts
// FIXME import ui concepts
//--------------------------ahahahah----------ja mexi nisto

/**
 * 4.3.2. Display all works.
 */
public class DoDisplayWorks extends Command<LibraryManager> {

  /**
   * @param receiver
   */
  public DoDisplayWorks(LibraryManager receiver) {
    super(Label.SHOW_WORKS, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _display.addLine(_receiver.doShowAllWorks());
    _display.display();
    // FIXME implement command
  }
}