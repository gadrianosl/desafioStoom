package com.desafiostoom.CRUD_Endereco.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class geoCodeController {
    @RequestMapping(path = "/geocode", method = RequestMethod.GET)
    public String getGeocode(@RequestParam String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        Request request = new Request.Builder().url("https://maps.googleapis.com/maps/api/geocode/json?address="
                + encodedAddress + "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw").get().build();
        // .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
        // .addHeader("x-rapidapi-key",
        // "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw").build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        return responseBody.string();
    }
}
