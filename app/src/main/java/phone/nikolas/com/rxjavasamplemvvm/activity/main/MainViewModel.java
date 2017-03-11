package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

//import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Pleret on 3/11/2017.
 */

public class MainViewModel extends BaseObservable{

    public boolean isInProgress = false;
    @Bindable
    public boolean isInprogress(){
        return isInProgress;
    }

    public void setInProgress(boolean inProgress){
        this.isInProgress = inProgress;
//        notifyPropertyChanged(BR.);
    }


}
