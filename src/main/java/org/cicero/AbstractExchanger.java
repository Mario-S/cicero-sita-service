package org.cicero;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import static org.springframework.util.StringUtils.isEmpty;

/**
 *
 */
abstract class AbstractExchanger {
    
    HttpEntity newEntity(){
        return newEntity(null);
    }
    
    HttpEntity newEntity(String key) {
        HttpHeaders headers = new HttpHeaders();
        if(!isEmpty(key)){
            headers.set("X-apiKey", key);
        }
        return new HttpEntity(headers);
    }
    
    
}
