package ru.practicum.mainservice.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.mainservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findAllBy(Pageable pageable);
}
