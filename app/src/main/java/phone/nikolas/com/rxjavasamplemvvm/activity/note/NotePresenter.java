package phone.nikolas.com.rxjavasamplemvvm.activity.note;

import java.util.ArrayList;
import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.base.BasePresenter;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;

/**
 * Created by Pleret on 3/18/2017.
 */

public class NotePresenter extends BasePresenter<NoteView,NoteViewModel> {


    public void showNoteAdd(){
        view.showDetailNote();
    }
}
