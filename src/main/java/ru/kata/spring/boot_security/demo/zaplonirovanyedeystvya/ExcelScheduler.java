package ru.kata.spring.boot_security.demo.zaplonirovanyedeystvya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.util.PsrserExel;
import ru.kata.spring.boot_security.demo.util.WriteZarodushy;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class ExcelScheduler {

    @Autowired
    PsrserExel psrserExel;

    @Autowired
    WriteZarodushy writeZarodushy;


    @PostConstruct
    public void init() {
        Timer timer = new Timer();

        // Задание, которое будет выполняться раз в сутки
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Вызов метода parsExel()
                try {
                    parsExel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0); // Задаем время выполнения (ноль часов)
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        // Запуск задания один раз в сутки
        timer.schedule(task, today.getTime(), 24 * 60 * 60 * 1000);
//        timer.schedule(task, today.getTime(), 5 * 60 * 1000); // todo интервал 5 минут - для отладки

    }

    public void parsExel() throws Exception {
        psrserExel.parsExel(); // todo RuntimeExeption ?
        System.out.println("Прошел парсинг с основного листа");
        writeZarodushy.writeExelZarodysh();
        System.out.println("Прошло сорхранение очерендной версии зародышей");
    }
}
