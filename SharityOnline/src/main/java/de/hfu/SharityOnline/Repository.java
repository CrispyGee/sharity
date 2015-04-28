package de.hfu.SharityOnline;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Repository<T> {
  
  private Datastore ds;
  
  public Repository(){
    try {
      ds = new Morphia().createDatastore(new MongoClient("localhost"), "SharityOnlineDb");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
  public T loadById(Class<?> T, String id){
    return (T) ds.find(T).field("_id").equal(id).get();
  }
  
  public void save(Object entity){
    ds.save(entity);
  }
  
  @SuppressWarnings("unchecked")
  public List<T> loadAll(Class<?> T){
    return (List<T>) ds.find(T).asList();
  }


}