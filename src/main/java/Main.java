import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        System.out.println("Создаю потоки:");
        List<MyCallable> threadList = Arrays.asList(
                new MyCallable("1"),
                new MyCallable("2"),
                new MyCallable("3"),
                new MyCallable("4")
        );
        try {
            for (MyCallable myCallable : threadList) {
                Future<Integer> task = threadPool.submit((Callable<Integer>) myCallable);
                Integer counter = task.get();
                System.out.println("Количество сообщений: " + counter);
            }
            Integer counter = threadPool.invokeAny(threadList);
            System.out.println("Количество сообщений: " + counter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }
}

