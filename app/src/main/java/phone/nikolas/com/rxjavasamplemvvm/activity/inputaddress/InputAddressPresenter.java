package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import phone.nikolas.com.rxjavasamplemvvm.base.BasePresenter;
import phone.nikolas.com.rxjavasamplemvvm.model.Address;
import phone.nikolas.com.rxjavasamplemvvm.model.People;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressPresenter extends BasePresenter<InputAdressView, InputAddressViewModel> {


    private List<People> listAddres = new ArrayList<People>();

    public void addAddress() {
        Address tmp = new Address();
        String nm = viewModel.getName();
        String add = viewModel.getAddress();

        view.insertPeople(nm,add);
        
        /*view.addAdressAction(getListAddres());
        tmp.setName(viewModel.getName());
        tmp.setAddress(viewModel.getAddress());
        getListAddres().add(tmp);*/
    }

    public void updatePeopleList(){
        listAddres = view.getAllPeople();
        view.updatePeopleList(listAddres);
    }


//    public String getName() {
//        return viewModel.getName();
//    }

    public String getAddress() {
        return viewModel.getAddress();
    }


    public List<People> getListAddres() {
        return listAddres;
    }

    public void setListAddres(List<People> listAddres) {
        this.listAddres = listAddres;
    }
}
