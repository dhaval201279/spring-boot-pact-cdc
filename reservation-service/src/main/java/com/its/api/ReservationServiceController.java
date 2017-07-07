/**
 * 
 */
package com.its.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.its.entity.Reservation;

/**
 * @author Dhaval
 *
 */
@RestController
public class ReservationServiceController {

	@RequestMapping(value = "/producer/reservation/names", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Reservation fetchOne() {
        return new Reservation("Dhaval");
    }
}
