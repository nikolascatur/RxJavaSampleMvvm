package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Pleret on 3/12/2017.
 */
import phone.nikolas.com.rxjavasamplemvvm.BR;
public class ItemViewModel extends BaseObservable {
    private String email;

    public ItemViewModel(String email){
        this.email = email;
        setEmail(email);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
