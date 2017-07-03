package ru.itpark.onlineBanking.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;
import ru.itpark.onlineBanking.models.AccountTransaction;
import ru.itpark.onlineBanking.models.User;

import javax.xml.ws.Response;
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
        User user = restTemplate.exchange(url, HttpMethod.POST, entity, User.class).getBody();
        return user;
    }

    public String signup(User user) {
        restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/signup";

        HttpEntity<User> entity = new HttpEntity<User>(user);
        String responseSignUp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();

        return responseSignUp;
    }

    public List primaryTransactionList (Long userId) {
        restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/user/" + userId + "/primaryAccountTransaction";

        List primaryTransList = restTemplate.getForObject(url, List.class);
        return primaryTransList;
    }

    public List savingsTransactionList (Long userId) {
        restTemplate = new RestTemplate(converters);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/user/").queryParam("user_id", new Object[]{Long.valueOf(userId)}).queryParam("/savingsAccountTransaction");
        String expandUrl = builder.toUriString();
        //String url = "http://localhost:8080/user/" + userId + "/savingsAccountTransaction";

        List savingsTransList = restTemplate.getForObject(expandUrl, List.class, new Object[0]);
        return savingsTransList;
    }
}