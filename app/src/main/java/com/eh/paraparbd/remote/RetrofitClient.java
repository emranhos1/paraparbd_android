//package com.eh.paraparbd.remote;
//
//public class RetrofitClient {
//
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient (String url){
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}
