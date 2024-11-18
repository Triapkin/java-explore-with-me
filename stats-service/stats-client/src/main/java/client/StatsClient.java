package client;

import dto.RequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatsClient {
    private final RestTemplate restTemplate = new RestTemplate();
    //    private static final String baseUrl = "http://localhost:9090";
    private static final String baseUrl = "http://stats-server:9090";

    public void addHit(RequestDto requestDto) {
        HttpEntity<RequestDto> request = new HttpEntity<>(requestDto);
        restTemplate.postForObject(baseUrl + "/hit", request, String.class);
    }
}