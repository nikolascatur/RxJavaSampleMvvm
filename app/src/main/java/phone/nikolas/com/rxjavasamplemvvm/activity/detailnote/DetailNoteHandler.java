package phone.nikolas.com.rxjavasamplemvvm.activity.detailnote;

/**
 * Created by Pleret on 3/22/2017.
 */

public class DetailNoteHandler {

    private DetailNotePresenter presenter;

    public DetailNotePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(DetailNotePresenter presenter) {
        this.presenter = presenter;
    }

    public void onClickButtonSubmit(){
        presenter.addNote();
    }
}
