package org.cicero;

import java.util.Map;
import org.junit.After;
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
public class GoogleControllerTest {
    private static final String EMPTY = "{}";
    private static final Double LAT = 52.520007;
    private static final Double LON = 13.404954;
    private static final Integer RADIUS = 500;

    @Mock
    private GoogleExchanger exchanger;

    @Mock
    private PropertiesAccess props;
    
    @Mock
    private HttpEntity entity;

    @InjectMocks
    private GoogleController classUnderTest;

    @Before
    public void setUp() {
        given(entity.getBody()).willReturn(EMPTY);
        given(exchanger.exchange(any(String.class), any(Map.class))).willReturn(entity);
    }

    /**
     * Test of trainstations method, of class GoogleController.
     */
    @Test
    public void testTrainstations() {
        String result = classUnderTest.trainstations(LAT, LON, RADIUS);
        assertEquals(EMPTY, result);
    }

    /**
     * Test of taxistands method, of class GoogleController.
     */
    @Test
    public void testTaxistands() {
        String result = classUnderTest.taxistands(LAT, LON, RADIUS);
        assertEquals(EMPTY, result);
    }

}
