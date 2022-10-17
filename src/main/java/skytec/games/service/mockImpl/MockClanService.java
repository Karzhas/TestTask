package skytec.games.service.mockImpl;

import skytec.games.exception.EntityNotFoundException;
import skytec.games.exception.NonUniqueResultException;
import skytec.games.exception.RepositoryException;
import skytec.games.model.Clan;
import skytec.games.repository.ClanRepository;
import skytec.games.service.domain.ClanService;
import skytec.games.util.Log;
import skytec.games.util.RandomUtil;

import java.util.concurrent.CompletableFuture;


public class MockClanService implements ClanService {
    private final ClanRepository clanRepository;
    private final Object goldAddLOCK = new Object();

    public MockClanService(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public CompletableFuture<Clan> getClan(long clanId) {
        Log.d("Get clan with ID: " + clanId);
        return clanRepository
                .findById(clanId)
                .thenApply(clan -> {
                    Log.d("Clan with ID: " + clanId + " has found: " + clan);
                    return clan;
                })
                .exceptionally(error -> {
                    Log.d("Failed to find clan with ID: " + clanId);

                    if (error instanceof EntityNotFoundException
                            || error instanceof NonUniqueResultException
                            || error instanceof IllegalArgumentException) {
                        RuntimeException wrapperException = new RepositoryException("Failed to find clan");
                        wrapperException.initCause(error);
                        throw wrapperException;
                    } else {
                        return null;
                    }
                });

    }

    @Override
    public CompletableFuture<Void> addGold(long clanId, int deltaGold) {
        Log.d("Adding gold for clanId: " + clanId + ", deltaGold: " + deltaGold);
        getClan(clanId)
                .thenCompose(clan -> {
                    Log.d("Gold in clan: " + clan + " BEFORE adding: " + clan.getGold());
                    return addGold(clan, deltaGold);
                })
                .thenAccept(clan -> {
                    Log.d("Adding SUCCESS > Gold in clan: " + clan + " after adding: " + clan.getGold());
                    System.out.println(clan);
                })
                .exceptionally(error -> {
                    Log.d("FAILED to add gold to " + clanId);
                    return null;
                });
        return null;
    }

    private CompletableFuture<Clan> addGold(Clan clan, int deltaGold) {
        // some logic1
        // some logic2
        // some logic3
        // Если произошла какая нибудь ошибка(недостаточно средств, превышен лимит и т.д) выбрасываем исключение
        if(RandomUtil.randomBoolean()){
            return CompletableFuture.failedFuture(new RuntimeException("some description"));
        }
        // критически важные кусочки кода синхронизируем, также можно использовать Locks если появляется более сложная логика, допустим отдельно лочим на чтение и на запись
        /*
            также если кланов небольшое количество, мы можем синхронизироваться на отдельных кланах по ID, т.к если золото добавляется по 2ум
            разным кланам, то они не должны дожидаться освобождения монитора
            synchronized(goldAddLOCKS.get(ID)){}
         */
        synchronized (goldAddLOCK) {
            clan.setGold(clan.getGold() + deltaGold);
        }
        return CompletableFuture.completedFuture(clan);

    }
}
