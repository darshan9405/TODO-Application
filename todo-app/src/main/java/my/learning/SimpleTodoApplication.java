package my.learning;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import my.learning.core.Task;

public class SimpleTodoApplication extends Application<SimpleTodoConfiguration> {

    private final HibernateBundle<SimpleTodoConfiguration> hibernate = new HibernateBundle<SimpleTodoConfiguration>(
            Task.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(SimpleTodoConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new SimpleTodoApplication().run(args);
    }

    @Override
    public String getName() {
        return "SimpleTodo";
    }

    @Override
    public void initialize(final Bootstrap<SimpleTodoConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final SimpleTodoConfiguration configuration,
            final Environment environment) {
        // TODO: implement application
    }

}
