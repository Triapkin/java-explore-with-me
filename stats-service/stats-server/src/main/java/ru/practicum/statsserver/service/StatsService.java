package ru.practicum.statsserver.service;

import dto.RequestDto;
import dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.statsserver.mapper.StatsMapper;
import ru.practicum.statsserver.model.Stats;
import ru.practicum.statsserver.repository.StatsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;
    private final StatsMapper statsMapper;

    public void saveHit(RequestDto requestDto) {
        Stats stats = statsMapper.toStats(requestDto);
        statsRepository.save(stats);
    }

    //TODO покрыть тестами уникальные\не уникальные
    public List<ResponseDto> findStats(LocalDateTime startTime, LocalDateTime endTime, List<String> uris, Boolean unique) {
        if (uris == null || uris.isEmpty()) {
            return statsRepository.findStatsByTimestamp(startTime, endTime);
        }
        if (unique) return statsRepository.findStatsByTimestampAndUriUnique(startTime, endTime, uris);

        return statsRepository.findStatsByTimestampAndUriNotUnique(startTime, endTime, uris);
    }
}
