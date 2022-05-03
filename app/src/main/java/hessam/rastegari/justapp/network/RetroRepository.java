package hessam.rastegari.justapp.network;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import hessam.rastegari.justapp.model.RecyclerData;
import hessam.rastegari.justapp.model.RecyclerList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {

      private RetroInterfaceServices retroInterfaceServices;

      public RetroRepository(RetroInterfaceServices retroInterfaceServices){
         this.retroInterfaceServices = retroInterfaceServices;
      }

      public void makeAPICall(String query, MutableLiveData<List<RecyclerData>> liveData){
         Call<RecyclerList> call = retroInterfaceServices.getDataFromGitHubApi(query);
         call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()){
                    liveData.postValue(response.body().getItems());
                }else{
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveData.postValue(null);
            }
         });
      }
}
