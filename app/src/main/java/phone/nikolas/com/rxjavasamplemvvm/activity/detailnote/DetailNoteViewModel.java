package phone.nikolas.com.rxjavasamplemvvm.activity.detailnote;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import phone.nikolas.com.rxjavasamplemvvm.BR;

/**
 * Created by Pleret on 3/22/2017.
 */

public class DetailNoteViewModel extends BaseObservable {
    private String noteText;

    @Bindable
    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
        notifyPropertyChanged(BR.noteText);
    }


}
