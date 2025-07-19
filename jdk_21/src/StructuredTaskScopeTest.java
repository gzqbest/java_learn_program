import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;

public class StructuredTaskScopeTest {
    public static void main(String[] args) {
        /*
         将一组任务视为一个单元，要么同时成功，要么同时失败
         */
        try(StructuredTaskScope<Object> taskScope = new StructuredTaskScope.ShutdownOnFailure()){
            StructuredTaskScope.Subtask<String> task1 = taskScope.fork(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("任务一开始");
                    Integer a = 0;
                    Integer b = 100;

                    return STR."结果为 \{b / a}";
                }
            });

            StructuredTaskScope.Subtask<String> task2 = taskScope.fork(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("任务二开始");
                    Integer a = 0;
                    Integer b = 100;

                    return STR."结果为 \{b / a}";
                }
            });

            taskScope.join();

            String s = task1.get();
            String s1 = task2.get();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
