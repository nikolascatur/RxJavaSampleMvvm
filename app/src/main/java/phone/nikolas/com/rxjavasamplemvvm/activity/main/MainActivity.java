package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RecycleViewAdapter;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityMainBinding;
import phone.nikolas.com.rxjavasamplemvvm.depen.componen.AppComponent;
import phone.nikolas.com.rxjavasamplemvvm.networking.NetworkService;
import phone.nikolas.com.rxjavasamplemvvm.networking.Service;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel,MainPresenter> implements MainView {

    @Inject
    public Service service;

    @Override
    protected void initInjection() {
        ((BaseApp)getApplication()).getmAppComponent().inject(this);
    }

    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

    }

    @Override
    protected void initViewModel() {
        viewModel = new MainViewModel();
        binding.setViewModel(viewModel);

    }

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(service);
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedinstance) {
        init();
    }

    private void init(){
        MainHandler handler = new MainHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
//        binding.list.
    }


    @Override
    public void onSuccessFetchData(List<String> emailData) {
        RecycleViewAdapter adapter = new RecycleViewAdapter(emailData);
        binding.list.setAdapter(adapter);
    }

    @Override
    public void onErrorFetchData(String error) {

    }
}
