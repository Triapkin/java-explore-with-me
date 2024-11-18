package client;

import dto.RequestDto;
import dto.ResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

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