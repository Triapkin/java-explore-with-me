package ru.practicum.mainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.mainservice.model.Request;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    Request findRequestByRequesterIdAndEventId(Integer requesterId, Integer eventId);

    Request findByEventId(Integer eventId);

    Request findByRequester_Id(Integer requesterId);

    Request findByEventIdAndRequesterId(Integer eventId, Integer requesterId);

    List<Request> findAllByRequester_Id(Integer userId);

    Boolean existsParticipationRequestByRequester_idAndEvent_Id(Integer userId, Integer eventId);

    List<Request> findAllByEvent_Id(Integer eventId);

    List<Request> findAllByRequester_IdAndEvent_Id(Integer userId, Integer eventId);
}
