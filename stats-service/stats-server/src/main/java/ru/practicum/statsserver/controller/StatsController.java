package ru.practicum.statsserver.controller;


import dto.RequestDto;
import dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.statsserver.service.StatsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class StatsController {

    private StatsService statsService;

    @PostMapping("/hit")
    public void createNewHit(@RequestBody RequestDto requestDto) {
        statsService.saveHit(requestDto);
    }

    @GetMapping("/stats")
    public List<ResponseDto> getStats(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
                                      @RequestParam(required = false) List<String> uris,
                                      @RequestParam(defaultValue = "false") Boolean unique) {
        return statsService.findStats(start, end, uris, unique);
    }
}
