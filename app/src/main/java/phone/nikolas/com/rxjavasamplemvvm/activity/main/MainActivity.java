package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import javax.inject.Inject;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress.InputAddressActivity;
import phone.nikolas.com.rxjavasamplemvvm.activity.note.NoteActivity;
import phone.nikolas.com.rxjavasamplemvvm.adapter.RecycleViewAdapter;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityMainBinding;
import phone.nikolas.com.rxjavasamplemvvm.depen.componen.AppComponent;
import phone.nikolas.com.rxjavasamplemvvm.networking.NetworkService;
import phone.nikolas.com.rxjavasamplemvvm.networking.Service;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel, MainPresenter> implements MainView {

    @Inject
    public Service service;

    //activity di inject kedalam AppComponent
    @Override
    protected void initInjection() {

        ((BaseApp) getApplication()).getmAppComponent().inject(this);
    }

    //set binging dengan layoutnya
    @Override
    protected void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    //define view model dan menghubungkan dengan binding
    @Override
    protected void initViewModel() {
        viewModel = new MainViewModel();
        binding.setViewModel(viewModel);

    }

    //define presenter dan menghubungkan view dan viewModel
    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(service);
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    //ketika semua sudah dihubungkan tinggal menghubungan binding layout dan handler nya,
    // dan cardview klo ada
    @Override
    protected void onViewReady(Bundle savedinstance) {
        init();
    }


    private void init() {
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

    @Override
    public void moveToInputAddress() {
        Intent intent = new Intent(this, InputAddressActivity.class);
        startActivity(intent);
    }

    @Override
    public void showInputNote() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
