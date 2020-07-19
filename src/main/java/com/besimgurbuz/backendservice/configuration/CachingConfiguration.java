package com.besimgurbuz.backendservice.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Besim Gurbuz
 */
@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfiguration {

    private String REPOS = "repos";
    private String STEAM_PROFILE = "steam";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(REPOS, STEAM_PROFILE);
    }

    @CacheEvict(allEntries = true, value = { "repos", "steam" })
    @Scheduled(fixedDelay = 1000 * 60 * 60)
    public void reportCacheEvict() {
        System.out.println("Cached values removed: " + REPOS + ", " + STEAM_PROFILE);
    }
}
