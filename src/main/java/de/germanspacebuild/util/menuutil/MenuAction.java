package de.germanspacebuild.util.menuutil;

/**
 * Created by Felix on 13.03.2018
 * for MenuUtil
 *
 * @author Felix
 */
@FunctionalInterface
public interface MenuAction {

    /**
     * Contains the code that will be run when the action was selected by the user.
     */
    void action();

}
