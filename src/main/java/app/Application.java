package app;

import app.config.AppConfig;
import app.model.AnimalsCage;
import app.model.Timer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        AnimalsCage animalsCage = applicationContext.getBean(AnimalsCage.class);

        for (int i = 0; i < 5; i++) {
            animalsCage.whatAnimalSay();
        }

        // Получение бина Timer из контекста Spring
        Timer timer = applicationContext.getBean(Timer.class);

        // Печать времени, прошедшего с момента создания контекста Spring
        System.out.println("Elapsed time since Spring context creation: " +
                (System.nanoTime() - timer.getTime()) + " nanoseconds");
    }

}