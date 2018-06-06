/**
 * 
 */
package com.joelgtsantos.v1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Joel Santos
 *
 * spring5-rest-api
 * 2018
 */
public abstract class AbstractRestControllerTest {

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
