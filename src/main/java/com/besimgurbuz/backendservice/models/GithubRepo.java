package com.besimgurbuz.backendservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

/**
 * @author Besim Gurbuz
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepo {
    private String name;

    private String description;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    private String language;

    @JsonProperty("stargazers_count")
    private int stargazersCount;

    private RepoLicense license;

    @JsonProperty("open_issues_count")
    private int openIssuesCount;

    private boolean fork;
}
