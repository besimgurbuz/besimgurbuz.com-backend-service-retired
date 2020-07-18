package com.besimgurbuz.backendservice.service;

import com.besimgurbuz.backendservice.client.GithubClient;
import com.besimgurbuz.backendservice.model.GithubRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Besim Gurbuz
 */
@Service
public class GithubRepositoryService {

    @Autowired
    GithubClient client;

    @Cacheable(value = "repos")
    public List<GithubRepo> getAllRepos() throws IOException, InterruptedException {
        // Request to Github API and get repos
        HttpResponse response = client.getRepos();

        // Read response body and parse it as List of GithubRepo POJO.
        String bodyString = (String) response.body();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.headers());
        List<GithubRepo> result = objectMapper.readValue(bodyString, new TypeReference<List<GithubRepo>>() {});
        return result.stream().filter(githubRepo -> !githubRepo.isFork()).collect(Collectors.toList());
    }
}
