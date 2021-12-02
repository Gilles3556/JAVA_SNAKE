package pndg.code.start;

import pndg.code.model.FacadeJeuSnake;
import pndg.code.presenter.PresenterSnake;

public class Lanceur {

    public static void main(String[] args) {
        PresenterSnake ps= new PresenterSnake();
        ps.executer();
    }
}
