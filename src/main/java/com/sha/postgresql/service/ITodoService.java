package com.sha.postgresql.service;

import com.sha.postgresql.model.TodoItem;

import java.util.List;

/**
 * @author sa
 * @date 2020-02-15
 * @time 13:42
 */
public interface ITodoService
{
    TodoItem save(TodoItem todoItem, String username);

    TodoItem completeTask(Long itemId);

    List<TodoItem> findWaitingList(Long userId);
}
