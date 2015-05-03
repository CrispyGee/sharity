package de.hfu.SharityOnline.backend;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.DELETE;

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

  public boolean deleteByID(Class<?> T, String id){
    ds.delete(T, id);
    if(ds.find(T).field("_id").equal(id).get() == null) {
      return true;
    } else {
      return false;
    }
  }
  
  @SuppressWarnings("unchecked")
  public T loadByKey(Class<?> T, String key, String value){
    return (T) ds.find(T).field(key).equal(value).get();
  }
  
  public void save(Object entity){
    ds.save(entity);
  }
  
  @SuppressWarnings("unchecked")
  public List<T> loadWithLimit(int limit, Class<?> T) {
    return (List<T>) ds.find(T).limit(limit).asList();
  }
  
  @SuppressWarnings("unchecked")
  public List<T> loadAll(Class<?> T){
    return (List<T>) ds.find(T).asList();
  }


}
