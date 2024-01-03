package my.learning.resources;

import java.util.List;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

    @Path("/todo")
    @GET
    @Timed
    @UnitOfWork
    public List<Task> getAllTodoTasks() {
        return taskDAO.getAllTasks("TODO");
    }

    @Path("/wip")
    @GET
    @Timed
    @UnitOfWork
    public List<Task> getAllWIPTasks() {
        return taskDAO.getAllTasks("WIP");
    }

    @Path("/create")
    @POST
    @Timed
    @UnitOfWork
    public String createTask(@Valid Task t) {
        return taskDAO.createTask(t);
    }
}
