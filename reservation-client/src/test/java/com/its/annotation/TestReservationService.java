/**
 * 
 */
package com.its.annotation;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import com.its.api.ReservationAPIGateway;
import com.its.entity.Reservation;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

/**
 * @author Dhaval
 * 
 * Primary intent of this test case is to demonstrate annotation based approach for creating 
 * Consumer defined contract using PACT
 *
 */
public class TestReservationService {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	@Rule
	public PactProviderRule pactProviderRule = new PactProviderRule("reservation-provider-demo", this);

	@Pact(consumer = "reservation-consumer-demo")
	public PactFragment createFragment(PactDslWithProvider pactDslWithProvider) {
		System.out.println("####### Entering TestReservationService : createFragment");
		// @formatter:off
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json;charset=UTF-8");
		System.out.println("####### Leaving TestReservationService : createFragment after returning hard coded response");
		return pactDslWithProvider.given("test demo first state")
				.uponReceiving("ReservationDemoTest interaction")
					.path("/producer/reservation/names")
					.method("GET")
				.willRespondWith()
					.status(200)
					.headers(headers)
					.body("{" + 
								"\"name\" : \"Dhaval\"" + 
					"}")
					.toFragment();
	}

	@Test
	@PactVerification
	public void runTest() throws Exception {
		System.out.println("####### Entering TestReservationService : runTest");
		String url = pactProviderRule.getConfig().url();
		System.out.println("####### pactProviderRule.getConfig().url() : " + url);
		System.out.println("####### Invoking ReservationAPIGateway(url).retrieve() with url as - " + url);
		Reservation fetchedReservation = new ReservationAPIGateway(url+"/producer/reservation/names").fetchOne();
		System.out.println("####### Reservation returned by invoking fetchOne : " + fetchedReservation.getName());
		//assertEquals(Arrays.asList(new Reservation(1,"Dhaval"), new Reservation(2,"Yatharth")), fetchedReservations);
		assertEquals("Dhaval", fetchedReservation.getName());
		System.out.println("####### Leaving TestReservationService : runTest");
	}

}
