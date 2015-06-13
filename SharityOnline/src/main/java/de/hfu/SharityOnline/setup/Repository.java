package de.hfu.SharityOnline.setup;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import de.hfu.SharityOnline.entities.OfferMongo;

public class Repository<T> {
  
  private Datastore ds;
  
  public Repository(){
//    For Authentication:
//    MongoCredential mongoC = MongoCredential.createCredential("chris2", "admin", "passwort".toCharArray());
//    ds = new Morphia().createDatastore(new MongoClient(new ServerAddress("localhost"), Arrays.asList(mongoC)), "sharitydb");
//    Unauthorized:
      ds = new Morphia().createDatastore(new MongoClient(new ServerAddress("localhost")), "sharityonlinedb");
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
  
  public void dropCollection(Class<?> T){
    this.ds.delete(ds.createQuery(T));
  }

}
