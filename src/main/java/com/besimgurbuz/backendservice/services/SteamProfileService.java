package com.besimgurbuz.backendservice.services;

import com.besimgurbuz.backendservice.clients.SteamClient;
import com.besimgurbuz.backendservice.models.SteamProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Besim Gurbuz
 */

@Service
public class SteamProfileService {

    @Autowired
    SteamClient steamClient;

    public SteamProfile getProfile() {
        try {
            HttpResponse response = steamClient.getProfile();

            if (response != null) {
                String resString = (String) response.body();
                ObjectMapper mapper = new ObjectMapper();

                HashMap<String, HashMap<String, List<SteamProfile>>> map = new HashMap<>();
                map = mapper.readValue(resString, new TypeReference<HashMap<String, HashMap<String, List<SteamProfile>>>>() {});

                return map.get("response").get("players").get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
