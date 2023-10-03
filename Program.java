import Presenter.Presenter;
import View.ConsoleV;
import View.View;

public class Program {
    public static void main(String[] args) {
        Presenter<View> prog = new Presenter<View>(new ConsoleV());
        prog.start();
    }
}