package phone.nikolas.com.rxjavasamplemvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.main.ItemViewModel;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ItemMainBinding;

/**
 * Created by Pleret on 3/12/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MainViewHolder> {

    private List<String> emailData;

    public RecycleViewAdapter(List<String> emailData){
        this.emailData = emailData;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main,parent,false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.binding.setViewModel(new ItemViewModel(emailData.get(position)));
    }

    @Override
    public int getItemCount() {
        return emailData.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private ItemMainBinding binding;

        public MainViewHolder(ItemMainBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
