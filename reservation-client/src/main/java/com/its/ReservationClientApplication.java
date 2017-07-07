package com.its;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dhaval
 *
 */

@SpringBootApplication
public class ReservationClientApplication {

	public static void main(String[] args) {
		System.out.println("Entering ReservationClientApplication : main");
		SpringApplication.run(ReservationClientApplication.class, args);
		System.out.println("Leaving ReservationClientApplication : main");
	}
}
