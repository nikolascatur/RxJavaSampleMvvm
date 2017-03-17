package phone.nikolas.com.rxjavasamplemvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import phone.nikolas.com.rxjavasamplemvvm.R;
import phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress.InputAddressViewModel;
import phone.nikolas.com.rxjavasamplemvvm.activity.inputaddress.ItemInputViewModel;
import phone.nikolas.com.rxjavasamplemvvm.databinding.ItemInputBinding;
import phone.nikolas.com.rxjavasamplemvvm.model.Address;

/**
 * Created by Pleret on 3/17/2017.
 */

public class RvInputAddressAdapter extends RecyclerView.Adapter<RvInputAddressAdapter.InputAddressHolder> {

    private List<Address> address;

    public RvInputAddressAdapter(List<Address> address){
        this.address = address;
    }
    @Override
    public InputAddressHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemInputBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_input,parent,false);
        return new InputAddressHolder(binding);
    }

    @Override
    public void onBindViewHolder(InputAddressHolder holder, int position) {
        Address tmp = address.get(position);
        Log.e("TAG", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB ");
        holder.binding.setViewModel(new ItemInputViewModel(tmp.getName(),tmp.getAddress()));
    }

    @Override
    public int getItemCount() {
        return address.size();
    }

    public static class InputAddressHolder extends RecyclerView.ViewHolder{

        ItemInputBinding binding;
        public InputAddressHolder(ItemInputBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
