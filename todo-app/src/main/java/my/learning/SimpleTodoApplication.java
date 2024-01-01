package my.learning;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class SimpleTodoApplication extends Application<SimpleTodoConfiguration> {

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
    }

    @Override
    public void run(final SimpleTodoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
