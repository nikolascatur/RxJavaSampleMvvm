package phone.nikolas.com.rxjavasamplemvvm.activity.detailnote;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.note.NoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityDetailNoteBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;

/**
 * Created by Pleret on 3/22/2017.
 */

public class DetailNoteActivity extends BaseActivity<ActivityDetailNoteBinding,DetailNoteViewModel,DetailNotePresenter> implements DetailNoteView {
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
                Note note = ((BaseApp)getApplication()).getmAppComponent().getNotes().getNoteList().get(value);
                presenter.viewModel.setNoteText(note.getNoteDetail());
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
        ((BaseApp)getApplication()).getmAppComponent().getNotes().addNote(note);
        List<Note> tmp = ((BaseApp)getApplication()).getmAppComponent().getNotes().getNoteList();
        for (Note data: tmp
             ) {
            Log.d("TAG"," isi note  "+data.getNoteDetail());
        }
    }
}
