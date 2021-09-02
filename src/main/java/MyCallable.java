import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    public MyCallable(String name){
        super(name);
    }

    @Override
    public Integer call() {
        Integer counter = 0;
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(2500);
                counter++;
                System.out.println("Поток №" + getName() + ". Сообщение №" + counter);
            }
        } catch (InterruptedException err) {
            err.getMessage();
        } finally {
            System.out.printf("Поток %s завершен\n", getName());
        }
        return counter;
    }
}
