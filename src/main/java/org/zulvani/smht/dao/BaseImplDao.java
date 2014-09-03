package org.zulvani.smht.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zulvani.smht.db.Param;


public class BaseImplDao<T> implements BaseDao<T> {
  @SuppressWarnings("rawtypes")
  protected Class domainClass;

  @Autowired
  protected SessionFactory sessionFactory;

  @SuppressWarnings("rawtypes")
  public BaseImplDao() {
    this.domainClass = (Class) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public T save(T domain) {
    sessionFactory.getCurrentSession().saveOrUpdate(domain);
    return domain;
  }

  public T saveNew(T domain) {
    sessionFactory.getCurrentSession().save(domain);
    return domain;
  }

  public T update(T domain) {
    sessionFactory.getCurrentSession().update(domain);
    return domain;
  }

  public T delete(T domain) {
    sessionFactory.getCurrentSession().delete(domain);
    return domain;
  }

  public void deleteAll() {
    sessionFactory.getCurrentSession().createQuery(
        "delete from " + domainClass.getName()).executeUpdate();
  }

  @SuppressWarnings("unchecked")
  public List<T> readAll() {
    return sessionFactory.getCurrentSession()
        .createQuery("from " + domainClass.getName() + " order by id desc ")
        .list();
  }

  @SuppressWarnings("unchecked")
  public List<T> readAll(int start, int num) {
    return sessionFactory.getCurrentSession()
        .createQuery("from " + domainClass.getName() + " order by id desc ")
        .setFirstResult(start).setMaxResults(num).list();
  }

  @SuppressWarnings("unchecked")
  public List<T> readBy(Param... params) {
    String c = getClausa(params);
    return sessionFactory
        .getCurrentSession()
        .createQuery("from " + domainClass.getName() + c + " order by id desc ")
        .list();
  }
  
  @SuppressWarnings("unchecked")
  public T readLast() {
    List<T> l = sessionFactory.getCurrentSession()
        .createQuery("from " + domainClass.getName() + " order by id desc ")
        .setMaxResults(1).setFirstResult(0).list();
    return (l != null && l.size() > 0) ? l.get(0) : null;
  }

  @SuppressWarnings("unchecked")
  public T readFirst() {
    List<T> l = sessionFactory.getCurrentSession()
        .createQuery("from " + domainClass.getName() + " order by id asc")
        .setMaxResults(1).setFirstResult(0).list();
    return (l != null && l.size() > 0) ? l.get(0) : null;
  }
  
  @SuppressWarnings("unchecked")
  public T readById(int id) {
    return (T) sessionFactory.getCurrentSession().get(domainClass, id);
  }
  
  @SuppressWarnings("rawtypes")
  public int countAll() {
    List list = sessionFactory.getCurrentSession()
        .createQuery("select count(*) from " + domainClass.getName() + " x")
        .list();
    Integer count = ((Long) list.get(0)).intValue();
    return count;
  }
  
//  private String getClausa(Param... params) {
//    String c = "";
//    if (params != null && params.length > 0) {
//      int i = 0;
//      for (Param param : params) {
//        String field = param.getName();
//        Object value = param.getValue();
//
//        if (i == 0) {
//          if (value instanceof String) {
//            c = " where UPPER(" + field + ") LIKE UPPER('%" + value + "%') ";
//          } else if (value instanceof Integer || value instanceof Double
//              || value instanceof Float || value instanceof Short
//              || value instanceof Long) {
//            c = " where " + field + " = " + value;
//          }
//        } else {
//          if (value instanceof String) {
//            c += " and UPPER(" + field + ") LIKE UPPER('%" + value + "%') ";
//          } else if (value instanceof Integer || value instanceof Double
//              || value instanceof Float || value instanceof Short
//              || value instanceof Long) {
//            c += " and " + field + " = " + value;
//          }
//        }
//        i++;
//      }
//    }
//    return c;
//  }
  
  private String getClausa(Param... params) {
    String c = "";
    if (params != null && params.length > 0) {
      int i = 0;
      for (Param param : params) {
        String field = param.getName();
        Object value = param.getValue();

        if (i == 0) {
          if(param.getOperator().equals(Param.OPERATOR_LIKE)){
            c = " where UPPER(" + field + ") LIKE UPPER('%" + value + "%') ";
          }
          else{
        	if (value instanceof String) {
        		c = " where " + field + " = '" + value + "'";	
			}else{
				c = " where " + field + " = " + value;
			}
            
          }
        } else {
          if(param.getOperator().equals(Param.OPERATOR_LIKE)){
            c += " and UPPER(" + field + ") LIKE UPPER('%" + value + "%') ";
          }
          else{
          	if (value instanceof String) {
                c += " and " + field + " = '" + value + "'";
			}else{
	            c += " and " + field + " = " + value;
			}

          }
        }
        i++;
      }
    }
    return c;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<T> readBy(int start, int num, Param... params) {
    String c = getClausa(params);
    return sessionFactory
        .getCurrentSession()
        .createQuery("from " + domainClass.getName() + c + " order by id desc ")
        .setMaxResults(num)
        .setFirstResult(start)
        .list();
  }

  @Override
  public int countBy(Param... params) {
    String c = getClausa(params);
    
    return Integer.parseInt(String.valueOf(sessionFactory
            .getCurrentSession()
            .createQuery("select count(*) from " + domainClass.getName() + c)
            .list().get(0)));
    
  }

  @Override
  public T readByFirst(Param... params) {
    List<T> domains = readBy(params);
    return (domains != null && domains.size() > 0) ? domains.get(0) : null;
  }
}