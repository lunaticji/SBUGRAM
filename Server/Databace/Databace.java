package Server.Databace;
import Messages.Requests.User;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * in database we want to load information from fileSystem that turns to the one ConcurrentHashMap
 * ok we want to get one ObjectInputStream from path of file and then Initialization of Cache and closing fis , ois
 * ----
 * in first one we should create ObjectOutputStream instance ObjectInputStream from repository then write and close
 * that to Repository saved --- done
 * ----
 * from running Server to end of all clients PushingData Method called and ObjectOutputStream opened repository saved
 * to the fileSystem and closed
 * */

public class Databace implements Serializable{
    private static final File file = new File("/home/lunatic/Documents/Repository");

    ObjectInputStream ois;
    ObjectOutputStream oos;
    Repository repository = new Repository();
    public void pushingData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(repository);
            oos.flush();
            oos.close();
            System.out.println("works finished");
            System.exit(0);
        }catch (Exception e){}
    }

    public Databace (){
        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//            oos.writeObject(repository);
//            oos.flush();
//            oos.close();
//            System.out.println("works finished");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object temp = ois.readObject();
            repository = (Repository) temp;
            ois.close();
            System.out.println("initialize finished");
        }catch (Exception e){}
    }

    public  ConcurrentHashMap<String, User> getInstance(){
        return repository.getCache();
    }
}
class Repository implements Serializable{

    public ConcurrentHashMap<String,User> cache ;

    public Repository(){
        cache=new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, User> getCache() {
        return cache;
    }
}