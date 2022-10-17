package skytec.games.controller;

import skytec.games.model.ResponseEntity;
import skytec.games.service.domain.TaskService;
import skytec.games.util.Log;

import java.util.concurrent.CompletableFuture;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public CompletableFuture<ResponseEntity<Void>> completeTask(long clanId, long taskId){
        Log.d(String.format("request for completeTask, user-agent: %s, user: %s", "console", "someUser") );
        return taskService
                .completeTask(clanId, taskId)
                .thenApply(Void -> {
                    Log.d(String.format("return response from completeTask() for user: %s: , clan: %s", "someUser", "someUser"));
                    return new ResponseEntity<Void>("..");
                })
                .exceptionally(ex -> {
                    Log.d("failed to process completeTask request");
                    return new ResponseEntity<>(null,new RuntimeException(ex));
                });
    }
}
