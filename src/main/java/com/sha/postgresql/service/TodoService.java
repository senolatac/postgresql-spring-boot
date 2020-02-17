package com.sha.postgresql.service;

import com.sha.postgresql.model.TodoItem;
import com.sha.postgresql.model.User;
import com.sha.postgresql.repository.ITodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sa
 * @date 2020-02-15
 * @time 13:42
 */
@Service
public class TodoService implements ITodoService
{
    @Autowired
    private ITodoItemRepository todoItemRepository;

    @Autowired
    private IUserService userService;

    @Override
    public TodoItem save(TodoItem todoItem, String username)
    {
        User user = userService.findByUsername(username);
        todoItem.setUserId(user.getId());
        todoItem.setCreateDate(LocalDateTime.now());
        todoItem.setDone(false);
        todoItem.setUpdateDate(LocalDateTime.now());
        return todoItemRepository.save(todoItem);
    }


    @Override
    public TodoItem completeTask(Long itemId)
    {
        TodoItem todoItem = todoItemRepository.findById(itemId).orElse(null);
        todoItem.setUpdateDate(LocalDateTime.now());
        todoItem.setDone(true);
        return todoItemRepository.save(todoItem);
    }

    @Override
    public List<TodoItem> findWaitingList(Long userId)
    {
        return todoItemRepository.findByUserIdAndDoneFalse(userId);
    }
}
