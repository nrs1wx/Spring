package com.nurassyl.sis1.service;
import com.nurassyl.sis1.model.Task;
import org.springframework.stereotype.Service;
import com.nurassyl.sis1.exception.TaskNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task create (Task task){
        task.setId(nextId);
        nextId++;

        tasks.add(task);
        return task;

    }

    public List<Task> getAll(){
        return tasks;
    }

    public Task getById(Long id){
        for(Task task:tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }

    public Task update (Long id, Task updateTask){
        Task existingTask=getById(id);

        if (existingTask==null){
            return null;
        }

        existingTask.setTitle(updateTask.getTitle());
        existingTask.setCompleted(updateTask.isCompleted());
        existingTask.setDescription(updateTask.getDescription());
        existingTask.setPriority(updateTask.getPriority());

        return existingTask;
    }

    public boolean delete (Long id){
        Task task = getById(id);

        if(task==null){
            return false;
        }

        tasks.remove(task);
        return true;
    }



}
