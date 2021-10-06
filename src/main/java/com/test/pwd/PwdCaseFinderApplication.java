package com.test.pwd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PwdCaseFinderApplication implements CommandLineRunner {
	private static final Logger logger = LogManager.getLogger(PwdCaseFinderApplication.class);
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ConfigurableApplicationContext context;

	@Value("${url}")
	private String url;
	@Value("${maxRecords}")
	private Integer maxRecords;
	@Value("${increment}")
	private Integer increment;
	@Value("${startingNumber}")
	private Integer startingNumber;
	@Value("${fields}")
	private String fields;
	@Value("${casePrefix}")
	private String casePrefix;
	@Value("${julianDate}")
	String julianDate;
	@Value("${randomIncrement}")
	Boolean randomIncrement;

	@Value("${upperBound}")
	Integer upperBound;
	@Value("${lowerBound}")
	Integer lowerBound;

	public static void main(String[] args) {
		SpringApplication.run(PwdCaseFinderApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	public void run(String... args) throws Exception {
		Map<String,String> paramMap =  new HashMap();
		for (String s : args)
		{
			String[] keyValue = s.split("=");
			paramMap.put(keyValue[0], keyValue[1]);
		}
		setConfigData(paramMap);
		
		StringBuilder generatedCaseNumbersList = new StringBuilder();
		Integer nextNumber = new Integer(startingNumber);
		logger.info("Generating case numbers..");
		for (int i = 0; i < maxRecords; i++) {
			StringBuilder nextCaseNumber = new StringBuilder();
			nextCaseNumber.append(casePrefix).append(julianDate).append("-").append(nextNumber).append("%20");
			generatedCaseNumbersList.append(nextCaseNumber.toString());
			nextCaseNumber.setLength(0);
			if (!randomIncrement) {
				nextNumber = nextNumber + increment;
			} else {
				Random random = new Random();
				int randomIncrement = random.nextInt(upperBound - lowerBound) + lowerBound;
				nextNumber = nextNumber + randomIncrement;
			}
		}
		String finalUrl = url + generatedCaseNumbersList + fields;
		logger.info("\n\nCopy below url in the browser");
		logger.info(finalUrl);
		System.exit(SpringApplication.exit(context));
	}

	private void setConfigData(Map<String, String> paramMap) {
		if(paramMap.get("startingSequence")!=null) {
			startingNumber = Integer.valueOf(paramMap.get("startingSequence"));
		}else {
			logger.info("\n\nstartingSequence is required");
			System.exit(0);
		}
		
		if(paramMap.get("increment")!=null) {
			increment = Integer.valueOf(paramMap.get("increment"));
		}
		
		if(paramMap.get("julianDate")!=null) {
			julianDate = paramMap.get("julianDate");
		}else {
			logger.info("\n\n julianDate is required");
			System.exit(0);
		}
		
		if(paramMap.get("randomIncrement")!=null) {
			randomIncrement = Boolean.valueOf(paramMap.get("randomIncrement"));
		}
		
		if(paramMap.get("randomIncrement")!=null) {
			randomIncrement = Boolean.valueOf(paramMap.get("randomIncrement"));
		}
		
		if(paramMap.get("upperBound")!=null) {
			upperBound = Integer.valueOf(paramMap.get("upperBound"));
		}
		
		if(paramMap.get("lowerBound")!=null) {
			lowerBound = Integer.valueOf(paramMap.get("lowerBound"));
		}
		
		logger.info("startingNumber:"+startingNumber);
		logger.info("increment:"+increment);
		logger.info("julianDate:"+julianDate);
		logger.info("randomIncrement:"+randomIncrement);
		logger.info("upperBound:"+upperBound);
		logger.info("lowerBound:"+lowerBound);
		
	}

}
