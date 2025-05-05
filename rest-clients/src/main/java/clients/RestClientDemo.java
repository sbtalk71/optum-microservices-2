package clients;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public class RestClientDemo {

	public static void main(String[] args) {
		
		RestClient restClient=RestClient.create();
		
		//RestClient.Builder clientBuilder=RestClient.builder();
		
		ResponseEntity<String> resp=restClient
		.get()
		.uri("http://localhost:8080/emp/104")
		.accept(MediaType.APPLICATION_XML)
		.header("myname", "Shantanu")
		.retrieve()
		.toEntity(String.class);

		System.out.println(resp.getBody());
	}

}
