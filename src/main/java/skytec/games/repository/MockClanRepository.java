package skytec.games.repository;

import skytec.games.exception.EntityNotFoundException;
import skytec.games.exception.NonUniqueResultException;
import skytec.games.model.Clan;
import skytec.games.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MockClanRepository implements ClanRepository {


    private List<Clan> mockClans;


    @Override
    public CompletableFuture<Clan> findById(long id) {
        boolean IllegalArgumentExceptionHappened = RandomUtil.randomBoolean();
        boolean NonUniqueResultExceptionHappened = RandomUtil.randomBoolean();
        boolean EntityNotFoundExceptionHappened = RandomUtil.randomBoolean();
        if (IllegalArgumentExceptionHappened) {
            return CompletableFuture.failedFuture(new IllegalArgumentException("ID less than 0"));
        }
        if (NonUniqueResultExceptionHappened) {
            return CompletableFuture.failedFuture(new NonUniqueResultException("Multiple clans with ID:  " + id));
        }
        if (EntityNotFoundExceptionHappened) {
            return CompletableFuture.failedFuture(new EntityNotFoundException("No clan with ID: " + id));
        }

        return CompletableFuture.completedFuture(mockClans.get(RandomUtil.randomRange(0,9)));
    }
}
