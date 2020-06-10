package com.phool.searchfavouritephotos;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
interface class
 */

public interface ImageInterface {


    @GET("search/photos")
    Call<Images> searchPhotos(@Query("query") String query,
                              @Query("page") Integer page,
                              @Query("per_page") Integer perPage,
                              @Query("orientation") String orientation);
}
