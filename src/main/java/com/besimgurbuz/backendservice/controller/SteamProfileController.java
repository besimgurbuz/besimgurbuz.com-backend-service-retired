package com.besimgurbuz.backendservice.controller;

import com.besimgurbuz.backendservice.model.SteamProfile;
import com.besimgurbuz.backendservice.service.SteamProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Besim Gurbuz
 */
@RestController
@RequestMapping("api/v1/steam")
@CrossOrigin()
public class SteamProfileController {

    @Autowired
    SteamProfileService steamProfileService;

    @GetMapping("/profile")
    public SteamProfile getProfile() {
        return steamProfileService.getProfile();
    }
}
