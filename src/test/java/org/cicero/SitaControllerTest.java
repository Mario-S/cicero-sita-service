package org.cicero;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SitaControllerTest {
    
    private static final String EMPTY = "{}";
    
    @Mock
    private PropertiesAccess props;
    
    @Mock
    private SitaExchanger exchanger;
    
    @Mock
    private HttpEntity entity;
    
    @InjectMocks
    private SitaController classUnderTest;
    
    
    @Before
    public void setUp() {
        given(entity.getBody()).willReturn(EMPTY);
        given(exchanger.exchange(any(String.class), any(String.class), any(Map.class))).willReturn(entity);
    }
    

    /**
     * Test of waitTime method, of class SitaController.
     */
    @Test
    public void testWaitTime() {
        String airport = "FRA";
        String result = classUnderTest.waitTime(airport);
        assertEquals(EMPTY, result);
    }

    /**
     * Test of weather method, of class SitaController.
     */
    @Test
    public void testWeather() {
        String airport = "FRA";
        String result = classUnderTest.weather(airport);
        assertEquals(EMPTY, result);
    }
    
}
