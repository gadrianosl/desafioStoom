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
    public String getGeocode(@RequestParam String latlng) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String encodedLatLong = URLEncoder.encode(latlng, "UTF-8");
        Request request = new Request.Builder().url("https://maps.googleapis.com/maps/api/geocode/json?latlng="
                + encodedLatLong + "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw").get().build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        return responseBody.string();
    }
}
