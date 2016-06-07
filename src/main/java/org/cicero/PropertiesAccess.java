package org.cicero;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
class PropertiesAccess {

    @Value("${sitaApiKey}")
    private String sitaApiKey;

    @Value("${waitTimeApiKey}")
    private String waitTimeApiKey;

    @Value("${weatherApiKey}")
    private String weatherApiKey;

    @Value("${waitTimeRequest}")
    private String waitTimeRequest;

    @Value("${currentWeatherRequest}")
    private String currentWeatherRequest;

    @Value("${nearbyRequest}")
    private String nearbyRequest;

    @Value("${placesApiKey}")
    private String placesApiKey;

    String getSitaApiKey() {
        return sitaApiKey;
    }

    String getWaitTimeApiKey() {
        return waitTimeApiKey;
    }

    String getWeatherApiKey() {
        return weatherApiKey;
    }

    String getWaitTimeRequest() {
        return waitTimeRequest;
    }

    String getCurrentWeatherRequest() {
        return currentWeatherRequest;
    }

    String getNearbyRequest() {
        return nearbyRequest;
    }

    String getPlacesApiKey() {
        return placesApiKey;
    }
}
