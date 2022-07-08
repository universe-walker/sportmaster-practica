package com.sportmaster.Todo.handler;

import com.sportmaster.Todo.document.Task;
import com.sportmaster.Todo.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {
    private final TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> listTask(ServerRequest request) {
        Flux<Task> tasks = Flux.fromIterable(this.taskService.findAll());
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tasks, Task.class);
    }

    public Mono<ServerResponse> addTask(ServerRequest request) {
        Mono<Task> new_task = request.body(BodyExtractors.toMono(Task.class));
        return new_task.flatMap(task -> {
            this.taskService.save(task);
            return ServerResponse.ok().build();
        });
    }

    public Mono<ServerResponse> getTaskById(ServerRequest request) {
        Task task = this.taskService.findById(request.pathVariable("id"));
        return ServerResponse.ok().body(task, Task.class);
    }

    public Mono<ServerResponse> deleteTask(ServerRequest request) {
        String task_id = request.pathVariable("id");
        return (this.taskService.deleteTask(task_id)
                ? ServerResponse.ok()
                : ServerResponse.notFound()
        ).build();
    }

}
