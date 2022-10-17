package skytec.games.service.domain;


import java.util.concurrent.CompletableFuture;

public interface TaskService {

    CompletableFuture<Void> completeTask(long clanId, long taskId);

}
