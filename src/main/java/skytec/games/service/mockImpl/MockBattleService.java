package skytec.games.service.mockImpl;

import skytec.games.service.domain.BattleService;
import skytec.games.service.domain.ClanService;

import java.util.concurrent.CompletableFuture;

public class MockBattleService implements BattleService {
    private final ClanService clanService;

    public MockBattleService(ClanService clanService) {
        this.clanService = clanService;
    }

    @Override
    public CompletableFuture<Void> battleAtArena() {
        // такая же логика как и в MockUserAddGoldService
        // пишем специфичную логику для арены
        // и в конце при помощи ClanService реактивно добавляем золото клану за баттл
        return null;
    }
}
