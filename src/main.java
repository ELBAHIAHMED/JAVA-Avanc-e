public class main {
    public static void main(String[] args) {

        Runnable obj =new SanjiEtRobinJob();
        Thread Sanji =new Thread(obj);
        Thread Robin =new Thread(obj);
        Sanji.setName("sanji");
        Sanji.setName("Robin");

        Sanji.start();
        Robin.start();

    }
}
