package com.sportmaster.Todo.router;

import com.sportmaster.Todo.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class TaskRouter{
    @Bean
    public RouterFunction<ServerResponse> route(TaskHandler taskHandler) {
        return RouterFunctions.route()
                .GET("/api/task/list", taskHandler::listTask)
                .POST("/api/task", RequestPredicates.contentType(MediaType.APPLICATION_JSON),
                        taskHandler::addTask)
                .DELETE("/api/task/{id}", taskHandler::deleteTask)
                .GET("/api/task/{id}", taskHandler::getTaskById)
                .build();
    }
}
