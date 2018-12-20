package de.germanspacebuild.util.menuutil.action;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Felix on 11.11.2018
 * for MenuUtil
 *
 * @author Felix
 */
public class ActionRegistry {

    private HashMap<String, Method> actions;
    private static ActionRegistry INSTANCE = null;

    private ActionRegistry() {
        this.actions = new HashMap<>();
    }

    public void registerActions(MenuAction action) {

    }

    public Method getActionById(String id) {
        return actions.get(id);
    }

    public static void getActionMethods(final Class<?> type) {
        final List<Method> methods = new ArrayList<Method>();
        Class<?> klass = type;
        while (klass != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
            // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
            final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(ActionHandler.class)) {
                    Annotation annotInstance = method.getAnnotation(ActionHandler.class);
                    // TODO process annotInstance
                    methods.add(method);
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            klass = klass.getSuperclass();
        }
    }

    public static ActionRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ActionRegistry();
        }
        return INSTANCE;
    }

}
