/**
 * 
 */
package com.its.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.its.entity.Reservation;

/**
 * @author Dhaval
 *
 */

@RestController
@RequestMapping("/reservations")
public class ReservationAPIGateway {

	private String url;
    private RestTemplate restTemplate;
    
	public ReservationAPIGateway(@Value("${producer}") String url) {
		System.out.println("%%%%%% Entering ReservationAPIGateway : ReservationAPIGateway");
		this.url = url;
		this.restTemplate = new RestTemplate();
		System.out.println("%%%%%% Leaving ReservationAPIGateway : ReservationAPIGateway");
	}
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/names")
	public List<Reservation> retrieve() {
		System.out.println("Entering ReservationAPIGateway : retrieve with url as - " + url);
		ParameterizedTypeReference<List<Reservation>> responseType = new ParameterizedTypeReference<List<Reservation>>() {};
        final List<Reservation> reservation = restTemplate.exchange(url + "/producer/reservation/names", HttpMethod.GET, 
        										null, responseType).getBody();
        System.out.println("Leaving ReservationAPIGateway : retrieve");
        return reservation;
	}*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/name")
	public Reservation fetchOne() {
		System.out.println("%%%%%% Entering ReservationAPIGateway : fetchOne with url as - " + url);
		/*ParameterizedTypeReference<List<Reservation>> responseType = new ParameterizedTypeReference<List<Reservation>>() {};*/
        final Reservation reservation = restTemplate.getForObject(url, Reservation.class);
        System.out.println("%%%%%% Leaving ReservationAPIGateway : fetchOne");
        return reservation;
	}

}
