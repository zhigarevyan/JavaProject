package entity;

import java.util.List;

public class Manager {
    private List list;

    void Add(Object o) {
        list.add(o);
    }

    void Delete(Object o) {
        list.remove(o);
    }

    Object Get(Object o) {
        return list.get(list.indexOf(o));
    }


}
