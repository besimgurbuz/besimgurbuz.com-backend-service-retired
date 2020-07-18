package com.besimgurbuz.backendservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Besim Gurbuz
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamProfile {

    @JsonAlias({"personaname"})
    private String username;

    @JsonAlias({"profileurl"})
    private String profileUrl;

    @JsonAlias({"avatarmedium"})
    private String avatarUrl;

    @JsonAlias({"lastlogoff"})
    private int lastActivity;

}
