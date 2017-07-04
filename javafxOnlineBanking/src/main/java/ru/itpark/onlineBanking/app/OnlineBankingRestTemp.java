package ru.itpark.onlineBanking.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ru.itpark.onlineBanking.models.User;

import java.util.Arrays;
import java.util.List;

public class OnlineBankingRestTemp {

    private RestTemplate restTemplate;

    List<HttpMessageConverter<?>> converters = Arrays.asList(new MappingJackson2HttpMessageConverter());

    public User login(String username, String password) {
        restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/signin";

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", username);
        headers.add("password", password);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<User> user = restTemplate.postForEntity(url, entity, User.class);

        return user.getBody();
    }

    public User signup(User user) {
        //restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/signup";

        HttpEntity<User> entity = new HttpEntity<>(user);
        ResponseEntity<User> responseSignUp = restTemplate.postForEntity(url, entity, User.class);

        return responseSignUp.getBody();
    }

    public List primaryTransactionList (User user) {
        //restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/user/" + user.getUserId() + "/primaryAccountTransaction";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-token", user.getToken());

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List> primaryTransList = restTemplate.postForEntity(url, entity, List.class);
        List returnIn = primaryTransList.getBody();
        return returnIn;
    }

    public List savingsTransactionList (Long userId) {
       // restTemplate = new RestTemplate(converters);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/user/").queryParam("user_id", new Object[]{Long.valueOf(userId)}).queryParam("/savingsAccountTransaction");
        String expandUrl = builder.toUriString();
        //String url = "http://localhost:8080/user/" + userId + "/savingsAccountTransaction";

        List savingsTransList = restTemplate.getForObject(expandUrl, List.class, new Object[0]);
        return savingsTransList;
    }
}