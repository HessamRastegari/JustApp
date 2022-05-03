package hessam.rastegari.justapp.viewmodel;


import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.lifecycle.HiltViewModel;
import hessam.rastegari.justapp.model.RecyclerData;
import hessam.rastegari.justapp.network.RetroInterfaceServices;
import hessam.rastegari.justapp.network.RetroRepository;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;

    @Inject
    RetroInterfaceServices retroInterfaceServices;

    @Inject
    public MainActivityViewModel() {
        liveData = new MutableLiveData();
    }

    public MutableLiveData<List<RecyclerData>> getLiveData() {
        return liveData;
    }

    public void makeApiCall() {
        RetroRepository retroRepository = new RetroRepository(retroInterfaceServices);
        retroRepository.makeAPICall("us", liveData);
    }
}
