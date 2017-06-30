package ru.itpark.onlineBanking.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.itpark.onlineBanking.models.User;

public class OnlineBankingRestTemp {

    private RestTemplate restTemplate = new RestTemplate();

    public User login(String login, String password) {

        String url = "http://localhost:8080/signin";
        HttpHeaders headers = new HttpHeaders();
        headers.add("login", login);
        headers.add("password", password);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        User user = restTemplate.exchange(url, HttpMethod.POST, entity, User.class).getBody();
        return user;
    }
}
