package skytec.games.service.mockImpl;

import skytec.games.model.ResponseEntity;
import skytec.games.service.domain.ClanService;
import skytec.games.service.domain.TaskService;

import java.util.concurrent.CompletableFuture;

public class MockTaskService implements TaskService {

    private final ClanService clanService;

    public MockTaskService(ClanService clanService) {
        this.clanService = clanService;
    }

    @Override
    public CompletableFuture<Void> completeTask(long clanId, long taskId) {
        // такая же логика как и в MockUserAddGoldService
        // пишем специфичную логику для завершения таска
        // и в конце при помощи ClanService реактивно добавляем золото клану за завершение таска
        return null;
    }
}
