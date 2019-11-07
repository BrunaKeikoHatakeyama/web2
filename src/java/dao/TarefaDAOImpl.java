package dao;

import entidades.Tarefa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TarefaDAOImpl implements TarefaDAO {
    private EntityManagerFactory fat = Persistence.createEntityManagerFactory("jarewebPU");

    public void save(Tarefa tarefa){
        EntityManager em = fat.createEntityManager();        
        em.getTransaction().begin();
        if (tarefa.getId() > 0){
            em.merge(tarefa);
        } else {
            em.persist(tarefa);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Tarefa> list(){
        EntityManager em = fat.createEntityManager();
        Query q = em.createQuery("SELECT t FROM tarefa as T ORDER BY t.id");
        return q.getResultList();
    }
    
    public void delete(Tarefa tarefa){
        EntityManager em = fat.createEntityManager();        
        em.getTransaction().begin();
        
        if (!em.contains(tarefa)){
            tarefa = em.merge(tarefa);
        }
        em.remove(tarefa);        
        em.getTransaction().commit();
        em.close();
    }
    
    public Tarefa find(int id){
        EntityManager em = fat.createEntityManager();
        return em.find(Tarefa.class, id);
    }
}
