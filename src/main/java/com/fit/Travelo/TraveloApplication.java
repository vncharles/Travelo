package com.fit.Travelo;

import com.fit.Travelo.entity.EStatusBooking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TraveloApplication {
//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setDefaultEncoding("utf-8");
////        resolver.setMaxUploadSizePerFile(10240000);
//		multipartResolver.setMaxInMemorySize(4096);
//		multipartResolver.setMaxUploadSize(10 * 1024 * 1024); // 10 MB
//		return multipartResolver;
//	}

	public static void main(String[] args) {

		SpringApplication.run(TraveloApplication.class, args);

//		System.out.println(EStatusBooking.CANCEL);
	}

}
