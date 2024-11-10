package ru.practicum.statsserver.mapper;

import dto.RequestDto;
import org.mapstruct.Mapper;
import ru.practicum.statsserver.model.Stats;

@Mapper(componentModel = "spring")
public interface StatsMapper {
    Stats toStats(RequestDto requestDto);
}
