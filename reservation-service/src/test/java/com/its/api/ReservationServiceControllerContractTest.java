/**
 * 
 */
package com.its.api;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

/**
 * @author Dhaval
 *
 */

@RunWith(PactRunner.class)
@Provider("reservation-provider-demo")
@PactFolder("../reservation-client/target/pacts")
@VerificationReports({"console", "markdown"})
public class ReservationServiceControllerContractTest {
	@TestTarget
    public final Target target = new HttpTarget(8080);

    @BeforeClass
    public static void setUpProvider() {

    }

    @State("test demo first state")
    public void demoState() {
        System.out.println("Reservation Service is in demo state");
    }
}
