package ru.practicum.mainservice.mapper;

import org.mapstruct.*;
import ru.practicum.mainservice.dto.events.*;
import ru.practicum.mainservice.model.Event;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    @Mapping(target = "category", ignore = true)
    Event toEvent(NewEventDto newEventDto);

    EventFullDto toEventFullDto(Event event);

    List<EventShortDto> toEventShortDtos(List<Event> events);

    List<EventFullDto> toEventFullDtos(List<Event> events);

    @Mapping(target = "category", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Event event, UpdateEventUserRequest updateEventUserRequests);

    @Mapping(target = "category", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Event event, UpdateEventAdminRequest updateEventAdminRequest);
}