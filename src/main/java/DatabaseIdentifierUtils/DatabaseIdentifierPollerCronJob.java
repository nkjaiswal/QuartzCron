package DatabaseIdentifierUtils;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;
import java.util.Random;

public class DatabaseIdentifierPollerCronJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Current Time is " + new Date());
        DatabaseIdentifiers dbIdentifier = getCurrentDatabaseIdentity();
        System.out.println("Setting DB Identifier to " + dbIdentifier);
        DatabaseIdentifierStore.getInstance().setDbIdentifier(dbIdentifier);
        System.out.println("Current DatabaseIdentifier set is " + DatabaseIdentifierStore.getInstance().getDbIdentifier());
    }

    private DatabaseIdentifiers getCurrentDatabaseIdentity() {
        // Your logic for getting db Identifier, replace the below dummy logic
        Random random = new Random();
        if (random.nextBoolean()) {
            return DatabaseIdentifiers.PRIMARY;
        } else {
            return DatabaseIdentifiers.SECONDARY;
        }
    }
}
