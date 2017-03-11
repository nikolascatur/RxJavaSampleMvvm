package phone.nikolas.com.rxjavasamplemvvm.base;

/**
 * Created by Pleret on 3/11/2017.
 */

public abstract class BasePresenter<V,VM> {
    private V view;
    private VM viewModel;

    public void setView(V view) {
        this.view = view;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}
