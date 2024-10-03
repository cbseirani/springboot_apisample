package cbseirani.demo.service;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate _restTemplate;
    private final CacheManager _cacheManager;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate, CacheManager cacheManager) {
        _restTemplate = restTemplate;
        _cacheManager = cacheManager;
    }

    /*
        Query OpenMeteo current weather for Alexandria VA
     */
    @Cacheable("alexandria-weather")
    public String getWeatherForAlexandria() {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=38.8048&longitude=-77.0469&current_weather=true";
        return _restTemplate.getForObject(url, String.class);
    }

    /*
        Log contents of cache to ensure it's working
     */
    public void debugCache() {
        var cacheManager = (CaffeineCacheManager) _cacheManager;
        var cache = (Cache<Object, Object>) cacheManager.getCache("alexandria-weather").getNativeCache();
        cache.asMap().forEach((key, value) -> System.out.println(key + " = " + value));
    }
}