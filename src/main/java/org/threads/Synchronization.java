package org.threads;

/**
 * <b>Ответ:</b> Порядок не детерминирован — может быть "AB" или "BA".<p>
 * <b>Ловушка:</b> Оба метода имеют монитор на классе Synchronization.class (так
 * как static synchronized).
 * Они не могут выполняться одновременно, но кто первый захватит монитор —
 * зависит от планировщика потоков.<br> В тесте часто спрашивают: "Будет ли
 * взаимоблокировка (deadlock)?" — Нет, просто последовательное выполнение в
 * случайном порядке.
 */
public class Synchronization {
    public static void main(String[] args) {
        Thread t1 = new Thread(Synchronization::printA);
        Thread t2 = new Thread(Synchronization::printB);
        t1.start();
        t2.start();
    }

    public static synchronized void printA() {
        System.out.print("A");
    }

    public static synchronized void printB() {
        System.out.print("B");
    }
}
