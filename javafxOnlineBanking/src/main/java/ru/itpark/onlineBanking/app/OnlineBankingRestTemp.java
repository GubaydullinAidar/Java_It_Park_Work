package ru.itpark.onlineBanking.app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import ru.itpark.onlineBanking.models.User;

public class OnlineBankingRestTemp {

 //   private final String LOCALHOST = "http://localhost8080";
    private RestTemplate restTemplate = new RestTemplate();

    public OnlineBankingRestTemp() {

    }

    public User login(String login, String password) {

        String url = "http://localhost8080/signin";
        HttpHeaders headers = new HttpHeaders();
        headers.add("login", login);
        headers.add("password", password);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        User user = (User)this.restTemplate.getForObject(url, User.class, entity);
        return user;
    }
}
