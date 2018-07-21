package com.example.mohamedelnhrawy.baseproject.network;




import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface Service {

    @GET("marvel/")
    Call<ResponseBody> getMovies();



//    @GET("session")
//    Call<ResponseBody> getSession();
//
//    @POST("register")
//    Call<ResponseBody> createAccount(@Body User user);
//
//    @POST("login")
//    Call<ResponseBody> login(@Body LoginUser user);
//
//    @GET("slideshows")
//    Call<ResponseBody> getSlideShows();
//
//    @GET("featured/limit/{limit}")
//    Call<ResponseBody> getFeatured(@Path("limit") int limit);
//
//    @GET("products")
//    Call<ResponseBody> getAllProducts();
//
//    @GET("products/search/{search}")
//    Call<ResponseBody> searchAllProducts(@Path("search") String word);
//
//    @GET("wishlist")
//    Call<ResponseBody> getWishList();
//
//    @DELETE("wishlist/{product_id}")
//    Call<ResponseBody> removeFavoutite(@Path("product_id") String product_id);
//
//    @POST("wishlist/{product_id}")
//    Call<ResponseBody> addToFavoutite(@Path("product_id") int product_id);
//
//    @GET("latest")
//    Call<ResponseBody> getLatestProducts();
//
//    @GET("countries")
//    Call<ResponseBody> getCountriesList();
//
//    @GET("countries/{country_id}")
//    Call<ResponseBody> getzonesbyID(@Path("country_id") int country_id);
//
//    @GET("latest/limit/{limit}")
//    Call<ResponseBody>getLatestProductsLimit(@Path("limit") int limit);
//
//    @GET("products/{product_id}")
//    Call<ResponseBody> GetproductdetailsbyID(@Path("product_id") int country_id);
//
//    @POST("cart")
//    Call<ResponseBody> addItemtocart(@Body Product product);
//
//    @GET("cart")
//    Call<Cart> getCart();
//
//    @GET("cart")
//    Call<ResponseBody> getCartt();
//
//    @DELETE("cart/{key}")
//    Call<ResponseBody> deleteCartItem(@Path("key") String product_key);
//
//    @GET("account/address")
//    Call<Account_Addresses> getAccountAddresses();
//
//    //cart_bulk
//    @POST("cart_bulk")
//    Call<ResponseBody> Additemstocart(@Body List<Cart_Item> items);
//
//    //confirm
//    @POST("confirm")
//    Call<ResponseBody> confirmOrder();
//
//    ///logout
//    @POST("logout")
//    Call<ResponseBody> LOgout();
//
//    //account
//    @GET("account")
//    Call<Account> getAccount();
//
//
//    //cart
//    //paymentaddress
//    @GET("paymentaddress")
//    Call<Account_Addresses> Getcustomerspaymentaddresses();
//    @POST("paymentaddress")
//    Call<ResponseBody> Addnewpaymentaddresstoorder(@Body Address address);
//    //paymentaddress/existing  Set existing payment address to order
//    @POST("paymentaddress/existing")
//    Call<ResponseBody> Setexistpaymentaddresstoorder(@Body Cart_Fragment.address_id address_id);
//
//    //shippingaddress
//    @GET("shippingaddress")
//    Call<Account_Addresses> Getcustomersshippingaddresses();
//    @POST("shippingaddress")
//    Call<ResponseBody> Addnewshippingaddresstoorder(@Body Address address);
//    @POST("shippingaddress/existing")
//    Call<ResponseBody> Setexistingshippingaddresstoorder(@Body Cart_Fragment.address_id address_id);
//
//    //shippingmethods
//    //This method must called after POST guestshipping or POST shippingaddress because it depends on the customers delivery details.
//    @GET("shippingmethods")
//    Call<ShippingMethods> getshippingmethods();
//    //Set shipping method
//    @POST("shippingmethods")
//    Call<ResponseBody> setshippingmethod(@Body ShippingMethod shippingMethod);
//
//    //payment methods
//    //Get payment methods//This method must called after POST guest or POST paymentaddress because it depends on the customers billing details.
//    @GET("paymentmethods")
//    Call<ResponseBody> getPaymentmethods();
//    //paymentmethods
//    //Set payment method
//    @POST("paymentmethods")
//    Call<ResponseBody> Setpaymentmethod(@Body Payment item);
//
//    @PUT("cart")
//    Call<ResponseBody> Updatecartitemquantity(@Body Cart_updateItem cart_updateItem);


}

