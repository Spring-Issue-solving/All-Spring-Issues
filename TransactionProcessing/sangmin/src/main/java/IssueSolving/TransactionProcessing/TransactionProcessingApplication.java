package IssueSolving.TransactionProcessing;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionProcessingApplication.class, args);
	}

	@PostConstruct
	void initData(){

	}

}
