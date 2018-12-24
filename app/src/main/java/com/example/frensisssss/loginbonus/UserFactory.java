package com.example.frensisssss.loginbonus;

import java.util.ArrayList;

public class UserFactory {
    private static UserFactory singleton;
    private ArrayList<User> listaUtenti= new ArrayList<>();

    public static final UserFactory getInstance(){
        if(singleton == null) singleton = new UserFactory();

        return singleton;
    }

    private UserFactory(){
        User user1 = new User("frensis", "fre1993");
        User user2 = new User("conema", "conema1997");
        User user3 = new User("nikoPorci", "porci1996");

        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
    }

    public User getUtente(String us, String p){
        for (User u: listaUtenti)
            if(u.getUsername().equals(us) && u.getPassword().equals(p)) return u;

        return null;
    }
}
