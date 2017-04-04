package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.model.Address;
import phone.nikolas.com.rxjavasamplemvvm.model.People;

/**
 * Created by Pleret on 3/14/2017.
 */

public interface InputAdressView  {

    public void updatePeopleList(List<People> peoples);

    public void insertPeople(String nama,String alamat);

    public List<People> getAllPeople();

}
