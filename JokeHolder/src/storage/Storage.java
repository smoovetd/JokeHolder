package src.storage;

import src.exceptions.*;
import src.data.*;
import java.util.*;

public interface Storage{
    public boolean storeJoke(Joke crntJoke);

    public HashSet<Joke> getAllJokesFromDB(JokeFactory jokeFactory);

    public Joke getJokeById(long id)throws JokeCreationException;

    public Joke getJokeByTag(String tag)throws JokeCreationException;

    public boolean createStorageTable();

}
