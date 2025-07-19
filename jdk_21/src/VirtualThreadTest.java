import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class VirtualThreadTest {
    public static void main2(String[] args) throws InterruptedException {
        /*
        提供一种更高效、更轻量级的线程模型，可以在java应用程序中创建n+ (甚至上亿线程数)，不受操作系统线程数量限制
        更好地适应并发场景
        虚拟线程不需要线程池
        传统的物理线程 基于操作系统线程来实现，创建和上下文切换都是非常消耗系统资源；
        虚拟线程打破了平台线程和操作系统一一对应，虚拟线程等待时（io -> cpu 空闲）将它持有的物理线程释放给其它虚拟线程使用
        jdk 虚拟线程 被jdk 调度
        提高系统的吞吐量
         */
        List<Thread> list = IntStream.range(0, 4).mapToObj(new IntFunction<Thread>() {
            @Override
            public Thread apply(int value) {
                return Thread.ofVirtual().unstarted(() -> {
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread());
                });
            }
        }).toList();

        long begin = System.currentTimeMillis();
        for(Thread thread: list){
            thread.start();
            thread.join();
        }

        long end = System.currentTimeMillis();

        System.out.println(STR."create the \{list.size()} virtual thread");
        System.out.println(STR."执行耗时： \{(end - begin) / 1000.0}秒");

    }

    public static void main(){
        Thread t1 = Thread.startVirtualThread(()->{
            System.out.println("虚拟线程1执行");
        });

        Thread t2 = Thread.ofVirtual().start(()-> System.out.println("虚拟线程2执行了"));

        Thread t3 = Thread.ofVirtual().factory().newThread(() -> System.out.println("虚拟线程3执行了"));

        t3.start();

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()){
            Future<Integer> future = executorService.submit(() -> 1);
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
