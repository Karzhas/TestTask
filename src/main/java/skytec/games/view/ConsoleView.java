package skytec.games.view;

public class ConsoleView implements View{
    @Override
    public void showMessage(Object msg) {
        System.out.println(msg);
    }
}
