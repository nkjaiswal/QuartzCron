import DatabaseIdentifierUtils.DatabaseIdentifierPollerCronJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronJob {

    public static void main(String[] args) {
        JobDetail job1 = JobBuilder.newJob(DatabaseIdentifierPollerCronJob.class)
                .withIdentity("job1", "group1").build();

        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) //Move this "0/5 * * * * ?" to properties file
                .build();


        try {
            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);
        } catch (SchedulerException e) {
            // Log the exception here, must discuss what to do if it fail
            // Publish metrics for alarm
            System.out.println(e.toString());
        }

    }
}
