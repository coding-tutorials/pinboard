package org.codingtutorials;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<User> generate () {
        var list = new ArrayList<User>();
        var user = new User("Gisele");
        list.add(user);

        var user2 = new User("Ju");
        list.add(user2);
        list.add(new User("Mãe"));
        list.add(new User("Pai"));
        list.add(new User("Teste"));
        list.add(new User("Uhuuu"));
        list.add(new User("Teste 2"));
        list.add(new User("Teste 3"));

        return list;
    }
}
