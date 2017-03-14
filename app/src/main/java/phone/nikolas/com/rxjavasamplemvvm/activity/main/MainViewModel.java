package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import phone.nikolas.com.rxjavasamplemvvm.BR;

//import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Pleret on 3/11/2017.
 */

public class MainViewModel extends BaseObservable{

    private String emailText;
    public boolean isInProgress = false;
    private int visibilityEmail;
    @Bindable
    public boolean isInprogress(){
        return isInProgress;
    }

    public void setInProgress(boolean inProgress){
        this.isInProgress = inProgress;
//        notifyPropertyChanged(BR.);
    }

    @Bindable
    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
        notifyPropertyChanged(BR.emailText);
    }

    @Bindable
    public int getVisibilityEmail() {
        return visibilityEmail;
    }

    public void setVisibilityEmail(int visibilityEmail) {
        this.visibilityEmail = visibilityEmail;
//        notifyPropertyChanged(BR.emailText);
        notifyChange();
    }
}
