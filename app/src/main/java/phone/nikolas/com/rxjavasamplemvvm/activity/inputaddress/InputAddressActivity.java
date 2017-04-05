package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RvInputAddressAdapter;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityInputBinding;
import phone.nikolas.com.rxjavasamplemvvm.db.RealmConnection;
import phone.nikolas.com.rxjavasamplemvvm.model.Address;
import phone.nikolas.com.rxjavasamplemvvm.model.People;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressActivity extends BaseActivity<ActivityInputBinding,InputAddressViewModel,InputAddressPresenter>
        implements InputAdressView{

    @Inject
    RealmConnection realm;

    @Override
    protected void initInjection() {
        ((BaseApp)getApplication()).getmAppComponent().inject(this);

    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(InputAddressActivity.this, R.layout.activity_input);
    }

    @Override
    protected void initViewModel() {
        viewModel = new InputAddressViewModel();
        binding.setViewModel(viewModel);
    }

    @Override
    protected void initPresenter() {
        presenter = new InputAddressPresenter();
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedinstance) {
        InputAddressHandler handler = new InputAddressHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
        binding.listAddress.setLayoutManager(new LinearLayoutManager(this));

        realm.initRealm(this.getApplicationContext());
        presenter.updatePeopleList();
    }

    @Override
    public void updatePeopleList(List<People> peoples) {
        RvInputAddressAdapter adapter = new RvInputAddressAdapter(peoples);
        binding.listAddress.setAdapter(adapter);
    }

    @Override
    public void insertPeople(String nama, String alamat) {
        realm.insert(nama,alamat);
    }

    @Override
    public List<People> getAllPeople() {
        return realm.getAllData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
