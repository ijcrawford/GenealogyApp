package edu.quinnipiac.ser210.genealogyapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class ItemListFragment extends ListFragment implements View.OnClickListener{

    NavController navController = null;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.item_list).setOnClickListener(this);
        navController = Navigation.findNavController(view);
    }

    /*@Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //TODO: Add bundle(?) stuff based on which item is clicked
        navController.navigate(R.id.action_itemListFragment_to_itemDetailFragment);

    }*/

    @Override
    public void onClick(View view) {
        navController.navigate(R.id.action_itemListFragment_to_itemDetailFragment);
    }
}