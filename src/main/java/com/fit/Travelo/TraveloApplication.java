package com.fit.Travelo;

import com.fit.Travelo.entity.EStatusBooking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TraveloApplication {

	public static void main(String[] args) {

		SpringApplication.run(TraveloApplication.class, args);

//		System.out.println(EStatusBooking.CANCEL);
	}

}
