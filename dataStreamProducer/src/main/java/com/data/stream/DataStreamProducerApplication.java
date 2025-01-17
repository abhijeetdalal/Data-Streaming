package com.data.stream;

import com.data.stream.generator.GeneratorWebSocketHandler;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class DataStreamProducerApplication {

	private static final String MEETUP_RSVPS_ENDPOINT = "ws://localhost:8082";

	public static void main(String[] args) {
		SpringApplication.run(DataStreamProducerApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeConnection(GeneratorWebSocketHandler generatorWebSocketHandler) {
		return args -> {
			WebSocketClient standardWebSocketClient = new StandardWebSocketClient();
			standardWebSocketClient.execute(generatorWebSocketHandler, MEETUP_RSVPS_ENDPOINT);
		};
	}

}
