package org.cicero;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class SitaController {

    private static final Logger LOG = LoggerFactory.getLogger(SitaController.class);

    private static final String NA = "FRA";

    @Autowired
    private PropertiesAccess props;
    
    @Autowired
    private SitaExchanger exchanger;

    private Map<String, String> newMap(String airport) {
        Map<String, String> vars = new HashMap<>();
        vars.put("airport", airport);
        return vars;
    }

    private HttpEntity<String> exchange(String url, String key, Map<String, String> params) {
        return exchanger.exchange(url, key, params);
    }

    @RequestMapping("/waittime")
    public String waitTime(@RequestParam(value = "airport", defaultValue = NA) String airport) {
        LOG.info("airport code: {}", airport);
        
        //Mapping since this api only supports currently 2 airports
        if("DXB".equals(airport)){
            airport = "MCO";
        }else{
            airport = "DEN";
        }

        String url = props.getWaitTimeRequest();
        String key = props.getWaitTimeApiKey();

        return exchange(url, key, newMap(airport)).getBody();
    }

    @RequestMapping("/weather")
    public String weather(@RequestParam(value = "airport", defaultValue = NA) String airport) {
        LOG.info("airport code: {}", airport);

        String url = props.getCurrentWeatherRequest();
        String key = props.getWeatherApiKey();

        return exchange(url, key, newMap(airport)).getBody();
    }
}
