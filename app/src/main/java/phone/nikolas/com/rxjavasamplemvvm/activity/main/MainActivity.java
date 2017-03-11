package phone.nikolas.com.rxjavasamplemvvm.activity.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import phone.nikolas.com.rxjavasamplemvvm.BaseApp;
import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.base.BaseActivity;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ActivityMainBinding;
import phone.nikolas.com.rxjavasamplemvvm.depen.componen.AppComponent;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel,MainPresenter> implements MainView {

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
        presenter = new MainPresenter();
        presenter.setView(this);
        presenter.setViewModel(binding.getViewModel());
    }

    @Override
    protected void onViewReady(Bundle savedinstance) {

    }

    private void init(){
        MainHandler handler = new MainHandler();
        handler.setPresenter(presenter);
        binding.setHandler(handler);
//        binding.list.
    }
}
