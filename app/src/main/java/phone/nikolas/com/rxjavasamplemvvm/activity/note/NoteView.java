package phone.nikolas.com.rxjavasamplemvvm.activity.note;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.model.Note;
import phone.nikolas.com.rxjavasamplemvvm.model.Notes;

/**
 * Created by Pleret on 3/18/2017.
 */

public interface NoteView {

    public void showDetailNote();

    public List<Note> listNote();

    public void updateList();
}
