package phone.nikolas.com.rxjavasamplemvvm.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.detailnote.DetailNoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.activity.note.ItemViewModel;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ItemNoteBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Note;

/**
 * Created by Pleret on 3/27/2017.
 */

public class RecycleNoteAdapter extends RecyclerView.Adapter<RecycleNoteAdapter.NoteViewHolder> {

    private List<Note> noteData;
    private OnItemNoteListener onItemNoteListener;

    public RecycleNoteAdapter(List<Note> noteAdapter,OnItemNoteListener listener) {
        this.noteData = noteAdapter;
        this.onItemNoteListener = listener;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemNoteBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_note, parent, false);
        return new NoteViewHolder(binding,onItemNoteListener);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.binding.setViewModel(new ItemViewModel(noteData.get(position).getNoteDetail()));
    }

    @Override
    public int getItemCount() {
        return noteData.size();
    }


    public static class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemNoteBinding binding;
        OnItemNoteListener onItemNoteListener;


        public NoteViewHolder(ItemNoteBinding noteBinding, OnItemNoteListener listener) {
            super(noteBinding.getRoot());
            this.binding = noteBinding;
            this.binding.getRoot().setOnClickListener(this);
            this.onItemNoteListener = listener;
        }

        @Override
        public void onClick(View view) {
//            Note tmp = this.binding.
            onItemNoteListener.editDetailData(getAdapterPosition());
            Log.d("TAG", "click " + getAdapterPosition());
        }
    }

    public interface OnItemNoteListener {
        public void editDetailData(int position);
    }
}
