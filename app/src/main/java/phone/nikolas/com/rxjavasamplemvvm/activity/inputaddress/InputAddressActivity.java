package phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

import javax.security.auth.login.LoginException;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RvInputAddressAdapter;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityInputBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Address;

/**
 * Created by Pleret on 3/14/2017.
 */

public class InputAddressActivity extends BaseActivity<ActivityInputBinding,InputAddressViewModel,InputAddressPresenter>
        implements InputAdressView{

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
//        binding.setHandler(new InputAddressHandler());
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
    }

    @Override
    public void addAdressAction(List<Address> address) {
        Log.e("TAG", "addAdressAction: MASSSUKK ADRESSSSSSSS  " );
        RvInputAddressAdapter adapter = new RvInputAddressAdapter(address);
        binding.listAddress.setAdapter(adapter);
    }
}
