package phone.nikolas.com.rxjavasamplemvvm.activity.note;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import phone.nikolas.com.rxjavasamplemvvm.BR;

/**
 * Created by Pleret on 3/19/2017.
 */

public class ItemViewModel extends BaseObservable{

    private String noteShort;

    public ItemViewModel(String noteShort){
        this.noteShort = noteShort;
        setNoteShort(noteShort);
    }

    @Bindable
    public String getNoteShort() {
        return noteShort;
    }

    public void setNoteShort(String noteShort) {
        this.noteShort = noteShort;
        notifyPropertyChanged(BR.noteShort);
    }
}
