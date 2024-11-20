package ru.practicum.mainservice.mapper;

import org.mapstruct.*;
import ru.practicum.mainservice.dto.events.*;
import ru.practicum.mainservice.model.Event;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface EventMapper {
    @Mapping(target = "category", ignore = true)
    Event toEvent(NewEventDto newEventDto);

    @Mapping(source = "participantLimit", target = "participantLimit", qualifiedByName = "setParticipantLimit")
    @Mapping(source = "paid", target = "paid", qualifiedByName = "setPaid")
    @Mapping(source = "requestModeration", target = "requestModeration", qualifiedByName = "setRequestModeration")
    @Mapping(target = "createdOn", expression = "java(LocalDateTime.now())")
    EventFullDto toEventFullDto(Event event);

    List<EventShortDto> toEventShortDtos(List<Event> events);

    List<EventFullDto> toEventFullDtos(List<Event> events);

    @Mapping(target = "category", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Event event, UpdateEventUserRequest updateEventUserRequests);

    @Mapping(target = "category", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Event event, UpdateEventAdminRequest updateEventAdminRequest);


    @Named("setParticipantLimit")
    static Integer setParticipantLimit(Integer participantLimit) {
        if (participantLimit == null) return 0;
        return participantLimit;
    }

    @Named("setPaid")
    static Boolean setPaid(Boolean paid) {
        if (paid == null) return false;
        return paid;
    }

    @Named("setRequestModeration")
    static Boolean setRequestModeration(Boolean requestModeration) {
        if (requestModeration == null) return true;
        return requestModeration;
    }
}
