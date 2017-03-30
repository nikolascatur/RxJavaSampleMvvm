package phone.nikolas.com.rxjavasamplemvvm.activity.detailnote;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.note.NoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityDetailNoteBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;
import phone.nikolas.com.rxjavasamplemvvm.model.Notes;

/**
 * Created by Pleret on 3/22/2017.
 */

public class DetailNoteActivity extends BaseActivity<ActivityDetailNoteBinding,DetailNoteViewModel,DetailNotePresenter> implements DetailNoteView {
    @Inject
    Notes listNote;

    @Override
    protected void initInjection() {
        ((BaseApp)getApplication()).getmAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_note);
    }

    @Override
    protected void initViewModel() {
        DetailNoteViewModel viewModel = new DetailNoteViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new DetailNotePresenter();
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedinstance) {
        DetailNoteHandler handler = new DetailNoteHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int value = extras.getInt("VALUE");
            Log.d("TAG","valuee ::  "+value);
            if(value >= 0){
                Note note = listNote.getNoteList().get(value); //((BaseApp)getApplication()).getmAppComponent().getNotes().getNoteList().get(value);
                presenter.editTextDetail(note.getNoteDetail());
            }
        }
    }

    @Override
    public void closeDetailActivity() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void addNote(String note) {
        //((BaseApp)getApplication()).getmAppComponent().getNotes().addNote(note);
        listNote.addNote(note);
        List<Note> tmp = listNote.getNoteList(); //((BaseApp)getApplication()).getmAppComponent().getNotes().getNoteList();
        for (Note data: tmp
             ) {
            Log.d("TAG"," isi note  "+data.getNoteDetail());
        }
    }
}
