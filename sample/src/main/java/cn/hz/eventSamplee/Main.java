package cn.hz.eventSamplee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new Subject();
        EventChain chain = new EventChain(subject);
        Observer observer = new Observer();

        observer.bindEvents(subject, chain);

        //fireEvents
        subject.start();
    }
}
