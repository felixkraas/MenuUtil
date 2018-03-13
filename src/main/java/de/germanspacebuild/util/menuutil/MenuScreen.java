package de.germanspacebuild.util.menuutil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix on 13.03.2018
 * for MenuUtil
 *
 * @author Felix
 */
public class MenuScreen extends Screen {

    private Map<Integer, MenuAction> actions = new HashMap<>();

    public MenuScreen(String text) {
        super(text);
        setAwaitsInput(true);
    }

    @Override
    public void print() {
        super.print();
        performAction(Integer.valueOf(input));
    }

    @Override
    public void close() {
        super.close();
        actions.clear();
    }

    public void performAction(int number) {
        actions.get(number).action();
    }

    public void addMenuAction(int number, MenuAction action) {
        actions.put(number, action);
    }

}