package com.monese;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AssignmentApplicationIntegrationTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    @LocalServerPort
    private int port;

    @Test
    public void test1() {
        transfer("1", "2", "100");
        transfer("1", "2", "50");
        transfer("2", "1", "400");

        getBalance(2l);
        getBalanceHistory(2l);
    }

    private void transfer(String fromId, String toId, String balance) {
        String transferReq = String.format("{" +
                "\t\"fromAcctNum\":\"%s\",\n" +
                "\t\"toAcctNum\": \"%s\",\n" +
                "\t\"transferAmount\":\"%s\"\n" +
                "\t\n" +
                "}", fromId, toId, balance);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        //Content-Type
        HttpEntity<String> entity = new HttpEntity<String>(transferReq, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/send/transferMoney"), HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());
    }

    private void getBalance(Long id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/view/viewBalance?accountId=" + id), HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }

    private void getBalanceHistory(Long id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/view/viewAccountTransactions?accountId=" + id), HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
