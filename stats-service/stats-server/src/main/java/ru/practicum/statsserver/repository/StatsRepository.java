package ru.practicum.statsserver.repository;

import dto.ResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.statsserver.model.Stats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<Stats, Long> {
    @Query("""
            SELECT new dto.ResponseDto(s.app, s.uri, COUNT(s.ip))
            FROM Stats s
            WHERE s.timestamp BETWEEN :startTime AND :endTime
            GROUP BY s.app, s.uri
            ORDER BY COUNT(s.ip) DESC
            """)
    List<ResponseDto> findStatsByTimestamp(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    @Query("""
            SELECT new dto.ResponseDto(s.app, s.uri, COUNT(distinct s.ip))
            FROM Stats s
            WHERE s.timestamp BETWEEN :startTime AND :endTime
            AND s.uri in(:uri)
            GROUP BY s.app, s.uri
            ORDER BY COUNT(distinct s.ip) DESC
            """)
    List<ResponseDto> findStatsByTimestampAndUriUnique(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime, List<String> uri);

    @Query("""
            SELECT new dto.ResponseDto(s.app, s.uri, COUNT(s.ip))
            FROM Stats s
            WHERE s.timestamp BETWEEN :startTime AND :endTime
            AND s.uri in(:uri)
            GROUP BY s.app, s.uri
            ORDER BY COUNT(s.ip) DESC
            """)
    List<ResponseDto> findStatsByTimestampAndUriNotUnique(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime, List<String> uri);
}
