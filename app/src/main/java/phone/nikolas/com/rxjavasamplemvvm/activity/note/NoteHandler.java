package phone.nikolas.com.rxjavasamplemvvm.activity.note;

/**
 * Created by Pleret on 3/18/2017.
 */

public class NoteHandler {

    private NotePresenter presenter;

    public NotePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(NotePresenter presenter) {
        this.presenter = presenter;
    }


    public void onCickButton(){
        presenter.showNoteAdd();
    }

}
