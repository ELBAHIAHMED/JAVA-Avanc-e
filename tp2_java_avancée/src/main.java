public class main {
    public static void main(String[] args) {

        Banque banque = new Banque(100,1000);

        for (int depuis = 0; depuis < 100; depuis ++) {

            Runnable r = new Transferer(banque,depuis);
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
