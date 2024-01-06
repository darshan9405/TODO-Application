package my.learning.resources;

import java.util.List;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.PATCH;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import my.learning.core.Task;
import my.learning.db.TaskDAO;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Path("/")
    @GET
    @Timed
    @UnitOfWork
    public List<Task> getTask(@QueryParam("status") String status, @QueryParam("id") Long id) {
        if (status == null) {
            if (id == null) {
                return taskDAO.getAllTasks();
            }
            return List.of(taskDAO.getById(id));
        }
        return taskDAO.getAllTasksByStatus(status);
    }

    @Path("/")
    @POST
    @Timed
    @UnitOfWork
    public String createTask(@Valid Task t) {
        return taskDAO.createTask(t);
    }

    @Path("/")
    @DELETE
    @Timed
    @UnitOfWork
    public String deleteTask(@QueryParam("id") long id) {
        return taskDAO.deleteById(id);
    }

    @Path("/")
    @PATCH
    @Timed
    @UnitOfWork
    public void modifyTask(@Valid Task t) {
        if (t.getTaskId() != 0) {
            taskDAO.modifyTask(t);
        }
    }
}
