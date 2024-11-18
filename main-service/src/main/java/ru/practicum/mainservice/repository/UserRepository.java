package ru.practicum.mainservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.mainservice.model.User;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllByIdIn(Collection<Integer> id, Pageable pageable);
}
