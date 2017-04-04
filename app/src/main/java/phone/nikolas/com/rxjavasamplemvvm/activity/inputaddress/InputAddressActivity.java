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
import phone.nikolas.com.rxjavasamplemvvm.model.Address;
import phone.nikolas.com.rxjavasamplemvvm.model.People;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressActivity extends BaseActivity<ActivityInputBinding,InputAddressViewModel,InputAddressPresenter>
        implements InputAdressView{

    Realm realm;

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
        initRealm();

        presenter.updatePeopleList();
    }

    protected void initRealm() {
        Realm.init(this.getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void updatePeopleList(List<People> peoples) {
        RvInputAddressAdapter adapter = new RvInputAddressAdapter(peoples);
        binding.listAddress.setAdapter(adapter);
    }

    @Override
    public void insertPeople(String nama, String alamat) {
        realm.beginTransaction();
        People people = realm.createObject(People.class);
        people.setNama(nama);
        people.setAlamat(alamat);
        realm.commitTransaction();
    }

    @Override
    public List<People> getAllPeople() {
        List<People> peoples = new ArrayList<People>();
        Log.d("TAG","  value realm "+realm+"  ");
        RealmQuery<People> query = realm.where(People.class);
        RealmResults<People> result = query.findAll();
        for(People peop : result ){
            peoples.add(peop);
        }

        return peoples;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
