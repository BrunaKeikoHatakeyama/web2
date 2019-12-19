
package cdi;

import entidades.Cliente;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Utils {
    
    @Produces
    public EntityManagerFactory criarFabrica(){
        EntityManagerFactory factory 
            = Persistence
                .createEntityManagerFactory("jarewebPU");
        return factory;
    }
    
    @Produces
    public EntityManager criarConexao(EntityManagerFactory fabrica){
        return fabrica.createEntityManager();
    }
    
    public void enviarEmail(@ObservesAsync Cliente cliente){
        System.out.println("Email enviado");
    }
}
