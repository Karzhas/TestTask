package skytec.games;

import skytec.games.controller.BattleController;
import skytec.games.controller.ClanController;
import skytec.games.controller.TaskController;
import skytec.games.controller.UserController;
import skytec.games.util.RandomUtil;
import skytec.games.view.ConsoleView;
import skytec.games.view.View;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestDispatcher {

    private final ExecutorService executorService;
    private final ClanController clanController;
    private final TaskController taskController;
    private final UserController userController;
    private final BattleController battleController;
    private final View view;

    public RequestDispatcher(ExecutorService executorService, ClanController clanController, TaskController taskController, UserController userController, BattleController battleController, View view) {
        this.executorService = Executors.newFixedThreadPool(4);
        ;
        this.clanController = clanController;
        this.taskController = taskController;
        this.userController = userController;
        this.battleController = battleController;
        this.view = view;
    }

    public void runApp() {

        // RequestDispatcher что то наподобии ServletDispatcher который перенаправляет готовый response(model) из Controller во View
        // в нашем случае View это Console
        // в основе реактивное программирование с использованием CompletableFuture, но на реальных проектах удобнее и быстрее использовать RxJava2 либо WebFlux
        // Многие моменты упущены для упрощения
        while (true) {
            int randomEvent = RandomUtil.randomRange(1, 4);
            switch (randomEvent) {
                case 1 -> CompletableFuture.runAsync(() -> clanController
                        .getClan(1)
                        .thenAccept(response -> {
                            view.showMessage(response.getValue());
                        }), executorService);

                case 2 -> CompletableFuture.runAsync(() -> userController
                        .addGold(1, 1, 100)
                        .thenAccept(response -> {
                            view.showMessage("added");
                        }), executorService);

//                case 3 -> CompletableFuture.runAsync(() -> clanController
//                        .getClan(3)
//                        .thenAccept(response -> view.showMessage(response.getValue())), executorService);
//
//                case 4 -> CompletableFuture.runAsync(() -> clanController
//                        .getClan(4)
//                        .thenAccept(response -> view.showMessage(response.getValue())), executorService);
            }
        }
    }

    // Для упрощения не стал добавлять зависимости в классы, представим что за нас это сделает DI framework (dagger2, spring)
    public static void main(String[] args) throws InterruptedException {
        RequestDispatcher mainController = new RequestDispatcher(null, null, null, null, null, null);
        mainController.runApp();
    }

}


