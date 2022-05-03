package hessam.rastegari.justapp.network;

import hessam.rastegari.justapp.model.RecyclerList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroInterfaceServices {


 @GET("repositories")
 Call<RecyclerList> getDataFromGitHubApi(@Query("q") String query);
}
