package com.sha.postgresql.repository;

import com.sha.postgresql.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sa
 * @date 2020-02-09
 * @time 15:10
 */
public interface ITodoItemRepository extends JpaRepository<TodoItem, Long>
{
    List<TodoItem> findByUserIdAndDoneFalse(Long userId);
}
