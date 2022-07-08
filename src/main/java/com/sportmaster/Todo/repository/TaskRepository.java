package com.sportmaster.Todo.repository;

import com.sportmaster.Todo.document.Task;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskRepository extends ElasticsearchRepository<Task, String> {
}
