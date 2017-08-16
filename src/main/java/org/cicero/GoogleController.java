package org.cicero;

import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class GoogleController {

    private static final Logger LOG = LoggerFactory.getLogger(GoogleController.class);

    @Autowired
    private PropertiesAccess props;

    @Autowired
    private GoogleExchanger exchanger;

    private Map<String, String> newMap() {
        Map<String, String> vars = new HashMap<>();
        vars.put("api_key", props.getPlacesApiKey());
        return vars;
    }

    private Map<String, String> newLocationMap(Double lat, Double lon, Integer radiusInMeter) {
        Map<String, String> vars = newMap();
        vars.put("lat", Double.toString(lat));
        vars.put("lon", Double.toString(lon));
        vars.put("radius", Integer.toString(radiusInMeter));
        return vars;
    }

    @ApiOperation(value = "Find nearby train stations")
    @RequestMapping(value = "/trainstations", method=RequestMethod.GET)
    public String trainstations(@RequestParam(value = "lat", defaultValue = "0") Double lat,
            @RequestParam(value = "lon", defaultValue = "0") Double lon,
            @RequestParam(value = "radius", defaultValue = "500") Integer radiusInMeter) {

        Map<String, String> vars = newLocationMap(lat, lon, radiusInMeter);
        vars.put("types", "train_station|subway_station");

        return exchanger.exchange(props.getNearbyRequest(), vars).getBody();
    }

    @ApiOperation(value = "Find nearby taxi stands")
    @RequestMapping(value = "/taxistands", method=RequestMethod.GET)
    public String taxistands(@RequestParam(value = "lat", defaultValue = "0") Double lat,
            @RequestParam(value = "lon", defaultValue = "0") Double lon,
            @RequestParam(value = "radius", defaultValue = "500") Integer radiusInMeter) {

        Map<String, String> vars = newLocationMap(lat, lon, radiusInMeter);
        vars.put("types", "taxi_stand");

        return exchanger.exchange(props.getNearbyRequest(), vars).getBody();
    }

}
