package com.besimgurbuz.backendservice.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author Besim Gurbuz
 */
@Component
@NoArgsConstructor
@Setter
@Getter
public class SteamClient {

    @Value("${steam.user.id}")
    private String userId;

    @Value("${steam.key}")
    private String key;

    private final String baseUrl = "https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002";

    public HttpResponse getProfile() throws IOException, InterruptedException {
        if (!userId.equals("none") && !key.equals("none")) {
            // Create URI
            URI requestUri = UriComponentsBuilder
                        .fromHttpUrl(baseUrl)
                        .queryParam("key", key)
                        .queryParam("steamids", userId)
                        .build()
                        .toUri();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(requestUri)
                    .timeout(Duration.ofMinutes(1))
                    .GET()
                    .build();
            // send request's response
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        return null;
    }
}
