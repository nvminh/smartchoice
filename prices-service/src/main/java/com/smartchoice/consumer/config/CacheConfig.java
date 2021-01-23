package com.smartchoice.consumer.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {
    @Value("${caches.prices.ttl.seconds}")
    private int cachePricesTtlInSeconds;
    @Value("${caches.prices.size}")
    private int cachePricesSize;

    @Bean
    @Profile("dev")
    public CacheManager cacheManagerDev() {
        // use simple cache dev
        return createCacheManager();
    }

    @Bean
    @Profile("!dev")
    public CacheManager cacheManager() {
        // we can use other cache for staging/production
        return createCacheManager();
    }

    private CacheManager createCacheManager() {
        return new ConcurrentMapCacheManager("prices") {
            @Override
            protected Cache createConcurrentMapCache(final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder().expireAfterWrite(cachePricesTtlInSeconds, TimeUnit.SECONDS)
                                .maximumSize(cachePricesSize).build().asMap(), false);
            }
        };
    }
}
