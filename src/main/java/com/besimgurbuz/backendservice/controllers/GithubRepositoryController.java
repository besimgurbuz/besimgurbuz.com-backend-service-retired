package com.besimgurbuz.backendservice.controllers;

import com.besimgurbuz.backendservice.models.GithubRepo;
import com.besimgurbuz.backendservice.services.GithubRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author Besim Gurbuz
 */
@RestController()
@RequestMapping("api/v1/")
@CrossOrigin()
public class GithubRepositoryController {

    @Autowired
    GithubRepositoryService service;

    @GetMapping("repos")
    public List<GithubRepo> getRepos() throws IOException, InterruptedException {
        return service.getAllRepos();
    }
}
