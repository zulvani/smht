package org.zulvani.smht.dao;

import java.util.List;

import org.zulvani.smht.db.Param;


public interface BaseDao<T> {

  /**
   * Save new domain to database each domain has id as unique id where id
   * is auto increment
   * 
   * @param domain
   * @return saved object
   * @author AgusZulvani
   */
  public T saveNew(T domain);

  /**
   * Save or update domain to database each domain has id as unique id where id
   * is auto increment
   * 
   * @param domain
   * @return saved object
   * @author AgusZulvani
   */
  public T save(T domain);
  
  public T update(T domain);

  public T delete(T domain);
  
  /**
   * Delete all row on entity table
   * 
   * @author AgusZulvani
   */
  public void deleteAll();
  
  /**
   * Get all row in entity table
   * 
   * @return {@link List} of object
   * @author AgusZulvani
   */
  public List<T> readAll();

  /**
   * Get all row in entity table
   * 
   * @param start
   * @param num
   * 
   * @author AgusZulvani
   */
  public List<T> readAll(int start, int num);

  public List<T> readBy(Param...params);
  
  public T readByFirst(Param...params);
  
  public List<T> readBy(int start, int num, Param...params);
  
  public T readById(int id);
  
  public T readLast();
  
  public T readFirst();
  
  int countAll();
  
  int countBy(Param...params);
}