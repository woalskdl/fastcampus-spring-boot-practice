package com.fastcampus.springbootpractice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

// redis 관련 세팅
@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(name -> name + ":") // : 를 하나만 표시
                .entryTtl(Duration.ofSeconds(10))   // redis ttl > 10초마다 캐시를 비워 메모리 관리
                .serializeValuesWith(RedisSerializationContext.
                        SerializationPair.
                        fromSerializer(
                                new GenericJackson2JsonRedisSerializer()
                        ) // serialization 관련 설정 > Student 클래스에 implements Serializable 제거해도 무
                );

    }
}
