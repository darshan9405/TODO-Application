package my.learning.db;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import my.learning.core.Task;
import java.util.List;

public class TaskDAO extends AbstractDAO<Task> {

    public TaskDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        // TODO Auto-generated constructor stub
    }

    public List<Task> getAllTasks(String status) {
        return list(namedTypedQuery("my.learning.core.Task.getAllTasks").setParameter("status", status));
    }

    public String createTask(Task t) {
        persist(t);
        long id = t.getTaskId();
        String cr = "Task created successfully with Id : %s";
        return String.format(cr, id);
    }
}
