package com.besimgurbuz.backendservice.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
public class GithubClient {

    @Value("${client.github.url}")
    private String URL;

    @Value("${client.github.token}")
    private String TOKEN;

    public HttpResponse getRepos() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
                TOKEN.equals("none") ?
                        HttpRequest.newBuilder()
                            .uri(URI.create(URL))
                            .timeout(Duration.ofMinutes(1))
                            .GET()
                            .build() :
                        HttpRequest.newBuilder()
                            .uri(URI.create(URL))
                            .timeout(Duration.ofMinutes(1))
                            .header("authorization", "Bearer " + TOKEN)
                            .GET()
                            .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
