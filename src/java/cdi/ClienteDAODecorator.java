package cdi;

import dao.ClienteDAO;
import entidades.Cliente;
import java.util.List;
import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class ClienteDAODecorator implements ClienteDAO {

    @Inject
    @Delegate
    @Any
    private ClienteDAO dao;

    @Inject
    private EntityManager manager;

    @Override
    public void save(Cliente cliente) {
        Query query = manager.createNamedQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf");
        query.setParameter("cpf", cliente.getCpf());
        List result = query.getResultList();
        if (result.isEmpty()) {
            dao.save(cliente);
        } else {
            System.out.println("CPF já cadastrado!");
        }
        dao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        dao.delete(cliente);
    }

    @Override
    public Cliente find(int id) {
        return dao.find(id);
    }

    @Override
    public List<Cliente> list() {
        return dao.list();
    }
}
