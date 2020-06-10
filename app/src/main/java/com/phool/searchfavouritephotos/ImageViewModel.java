package com.phool.searchfavouritephotos;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ImageViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
//    private MutableLiveData<Images> imageList;
//    Image image = new Image();
    private MutableLiveData<List<Results>> photosList;

    //we will call this method to get the data
    public LiveData<List<Results>> getPhotos( String query) {
        //if the list is null
        if (photosList == null) {
            photosList = new MutableLiveData<List<Results>>();
            //we will load it asynchronously from server in this method
            loadPhotos(query);
        }

        //finally we will return the list
        return photosList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadPhotos(String query) {

        ImageInterface apiInterface = ImageApi.createService(ImageInterface.class);
        Call<Images> call = apiInterface.searchPhotos(query,null,20,null);
        call.enqueue(new Callback<Images>() {
            @Override
            public void onResponse(Call<Images> call, Response<Images> response) {
                if(response.isSuccessful()){

                    photosList.setValue(response.body().getResults());
                    Log.d(TAG, "success");

                }else{
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(Call<Images> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
