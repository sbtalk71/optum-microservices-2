package clients;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.EmployeeDTO;

public class RestTemplateDemo {

	public static void main(String[] args) {
		
		RestTemplate restTemplate=new RestTemplate();
	
		String resp1=restTemplate.getForObject("http://localhost:8080/emp/104", String.class);
		
		System.out.println(resp1);
		
		EmployeeDTO resp2=restTemplate.getForObject("http://localhost:8080/emp/104", EmployeeDTO.class);
		
		System.out.println(resp2);
		
		//----Exchange Method----///
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity<Void> entity= new HttpEntity<>(headers);
		
		ResponseEntity<String> resp3= restTemplate.exchange("http://localhost:8080/emp/104",HttpMethod.GET,entity,String.class);
		
		System.out.println(resp3.getBody());
		

	}

}
