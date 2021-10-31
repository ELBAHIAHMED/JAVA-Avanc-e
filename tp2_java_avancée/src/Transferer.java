import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transferer  implements Runnable{
    private Banque banque ;
    private int de ;


    public  Transferer(Banque banque , int de )
    {
        this.banque = banque ;
        this.de = de ;
    }
    @Override
    public  void run() {


        int vers = (int) (banque.size()*Math.random()) ;

        //get a random amount of money < 1000
        double montant = banque.getSoldeInit()*Math.random(); //1000

        try {
            banque.transferer(de, vers, montant);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
