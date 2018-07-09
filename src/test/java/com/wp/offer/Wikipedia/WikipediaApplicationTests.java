package com.wp.offer.Wikipedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wp.offer.Wikipedia.domain.WikiOffer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class WikipediaApplicationTests {

	private static final String RESOURCE_LOCATION_PATTERN = "http://localhost/wiki/v1/offers";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${local.server.port}")
	private int port;

	@Test
	public void createRetrieveAndDeleteOffer() {
		//System.setProperty("proxyPort", "8090");
		//create an offer
		WikiOffer r1 = mockOffer("shouldCreateRetrieveDelete",new Random().nextInt());
		//restTemplate.put("http://localhost:" + port + "/wiki/v1/offers",r1);
		restTemplate.postForEntity("http://localhost:" + port +"/wiki/v1/offers", r1, WikiOffer.class);

		//retrieve the created offer
		ResponseEntity<WikiOffer> response = restTemplate.getForEntity("http://localhost:" + port + "/wiki/v1/offers/" + r1.getId(), WikiOffer.class, "");
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(r1.getName(),response.getBody().getName());

		String url = "http://localhost:" + port + "/wiki/v1/offers/{id}";
		long id = r1.getId();
		// delete

		//delete the created Offer
		ResponseEntity<WikiOffer> delResponse = restTemplate.exchange(url,
				HttpMethod.DELETE,
				HttpEntity.EMPTY,
				WikiOffer.class,
				id);

		Assert.assertEquals(delResponse.getBody().getId(), 0);
		Assert.assertEquals(delResponse.getBody().getName(),null);

	}

	private long getResourceIdFromUrl(String locationUrl) {
		String[] parts = locationUrl.split("/");
		return Long.valueOf(parts[parts.length - 1]);
	}


	private WikiOffer mockOffer(String prefix,long id)  {
		WikiOffer r = new WikiOffer();
		r.setOfferStatus("Active");
		r.setCurrency("GBP");
		r.setDescription("Wiki offer 1");
		r.setName("Offer1");
		r.setId(id);
		try{
			r.setOfferStartDate(DATE_FORMAT.parse("04/07/2018"));
		}catch(ParseException ex) {
			r.setOfferStartDate(new Date());
		}
		return r;
	}

	private byte[] toJson(Object r) throws Exception {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(r).getBytes();
	}





}
