package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Pleret on 3/14/2017.
 */

public class ItemInputViewModel extends BaseObservable {
    private String name;
    private String email;

    public ItemInputViewModel (String name, String email){
        setName(name);
        setEmail(email);
        Log.e("TAG", "AAAAAAA "+name+"  email  "+email );
    }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
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
