package phone.nikolas.com.rxjavasamplemvvm.activity.detailnote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import phone.nikolas.com.rxjavasamplemvvm.base.BasePresenter;
import phone.nikolas.com.rxjavasamplemvvm.depen.module.DatabaseModule;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;

/**
 * Created by Pleret on 3/22/2017.
 */

public class DetailNotePresenter extends BasePresenter<DetailNoteView,DetailNoteViewModel> {


    public void addNote(){
        view.addNote(viewModel.getNoteText());
        view.closeDetailActivity();
    }

    public void editTextDetail(String text){
        viewModel.setNoteText(text);
    }

/*
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }*/
}
