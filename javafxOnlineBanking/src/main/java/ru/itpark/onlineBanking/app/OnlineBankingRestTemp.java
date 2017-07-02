package ru.itpark.onlineBanking.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import ru.itpark.onlineBanking.models.User;

import java.util.Arrays;
import java.util.List;

public class OnlineBankingRestTemp {

    private RestTemplate restTemplate;

    List<HttpMessageConverter<?>> converters = Arrays.asList(new MappingJackson2HttpMessageConverter());

    public User login(String login, String password) {

        restTemplate = new RestTemplate(converters);

        String url = "http://localhost:8080/signin";
        HttpHeaders headers = new HttpHeaders();
        headers.add("login", login);
        headers.add("password", password);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        User user = restTemplate.exchange(url, HttpMethod.POST, entity, User.class).getBody();
        return user;
    }

    public String signup(User user) {
        return null;
    }
}