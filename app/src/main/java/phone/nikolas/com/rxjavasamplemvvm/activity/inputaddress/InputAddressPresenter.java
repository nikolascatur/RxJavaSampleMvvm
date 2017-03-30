package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import java.util.ArrayList;
import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.base.BasePresenter;
import phone.nikolas.com.rxjavasamplemvvm.model.Address;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressPresenter extends BasePresenter<InputAdressView, InputAddressViewModel> {

    private List<Address> listAddres = new ArrayList<Address>();

    public void addAddress() {
        Address tmp = new Address();
        String nm = viewModel.getName();
        String add = viewModel.getAddress();

        view.addAdressAction(getListAddres());
        tmp.setName(viewModel.getName());
        tmp.setAddress(viewModel.getAddress());
        getListAddres().add(tmp);
    }


//    public String getName() {
//        return viewModel.getName();
//    }

    public String getAddress() {
        return viewModel.getAddress();
    }


    public List<Address> getListAddres() {
        return listAddres;
    }

    public void setListAddres(List<Address> listAddres) {
        this.listAddres = listAddres;
    }
}
