package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import android.databinding.Bindable;
import android.util.Log;

import phone.nikolas.com.rxjavasamplemvvm.model.Address;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressHandler {
    private InputAddressPresenter presenter;

    public InputAddressPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(InputAddressPresenter presenter) {
        this.presenter = presenter;
    }


    public void clickButtonSubmit() {
        Log.e("TAG", "clickButtonSubmit: ");
        presenter.addAddress();
        presenter.updatePeopleList();
        /*for (Address address : presenter.getListAddres()
                ) {
            Log.d("addButton", address.getName() + "  " + address.getAddress());
        }*/
    }
}
