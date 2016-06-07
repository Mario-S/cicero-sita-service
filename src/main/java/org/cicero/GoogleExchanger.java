package org.cicero;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Component
class GoogleExchanger extends AbstractExchanger{
    
     HttpEntity<String> exchange(String url, Map<String, String> params) {
        RestTemplate template = new RestTemplate();
        HttpEntity<String> response = template.exchange(
                url, HttpMethod.GET, newEntity(), String.class, params);
        return response;
    }
}
