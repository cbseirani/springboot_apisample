package cbseirani.demo.controller;

import cbseirani.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/alexandria")
    public String getWeatherForAlexandria() {
        return weatherService.getWeatherForAlexandria();
    }

    @GetMapping("/debug-cache")
    public void debugCache() {
        weatherService.debugCache();
    }
}
