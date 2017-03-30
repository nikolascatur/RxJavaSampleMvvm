package phone.nikolas.com.rxjavasamplemvvm.activity.note;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.detailnote.DetailNoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RecycleNoteAdapter;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RecycleViewAdapter;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityInputBinding;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityNoteBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;
import phone.nikolas.com.rxjavasamplemvvm.model.Notes;

/**
 * Created by Pleret on 3/18/2017.
 */

public class NoteActivity  extends BaseActivity<ActivityNoteBinding,NoteViewModel,NotePresenter> implements NoteView{
    @Inject
    Notes listNote;

    @Override
    protected void initInjection() {
        ((BaseApp)getApplication()).getmAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note);
    }

    @Override
    protected void initViewModel() {
        viewModel = new NoteViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new NotePresenter();
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedinstance) {
        NoteHandler handler = new NoteHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
        binding.rvListNote.setLayoutManager(new LinearLayoutManager(this));
        Log.d("TAG","On view readyy");
        updateList();
    }

    @Override
    public void showDetailNote() {
        Intent intent = new Intent(this, DetailNoteActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public List<Note> listNote() {
        return listNote.getNoteList(); //((BaseApp)getApplication()).getmAppComponent().getNotes().getNoteList();
    }

    @Override
    public void updateList() {

//        final Context activityContext = this;
        RecycleNoteAdapter adapter = new RecycleNoteAdapter(listNote(), new RecycleNoteAdapter.OnItemNoteListener() {
            @Override
            public void editDetailData(int position) {
                Intent intent = new Intent(getApplicationContext(),DetailNoteActivity.class);
                intent.putExtra("VALUE",position);
                startActivity(intent);
                Log.d("TAG","  kkkkkkkkkkkkkkkkkkkk  "+position);
            }
        });

        binding.rvListNote.setAdapter(adapter);
    }
/*
    @Override
    public void updateList(List<String> data) {
        RecycleViewAdapter adapter = new RecycleViewAdapter(data);

    }*/
}
