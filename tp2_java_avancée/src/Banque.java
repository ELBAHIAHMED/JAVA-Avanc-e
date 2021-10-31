import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banque {
    private double[] comptes ;
    private int nbcompte=100;
    private double soldeinit=100;
    private Lock bankLock = new ReentrantLock(); //implements Lock i
    private Condition soldeSuffisant = bankLock.newCondition();




    public  Banque(int nbcompte , double solde){
        this.nbcompte=nbcompte;
        comptes=new double[nbcompte<=0 ? 100 : nbcompte];
         for (int i=0;i<nbcompte;i++){
             comptes[i]=soldeinit;
         }
         this.soldeinit=solde;

    }
    public double soldetotal(){
        double totalsolde=0;
        for(int i=0;i<nbcompte;i++) {
            totalsolde = totalsolde + comptes[i];}

        return totalsolde;
    }
    public void transferer (int i ,int j, double b) throws InterruptedException {
        bankLock.lock();
        try{
        if (comptes[i]<b){
            soldeSuffisant.await();
            System.out.println("le compte n'a pas suffisament d'argent");
        }
        else{
            System.out.println("le transfer est en train d'executer");
            comptes[j]+=b;
            comptes[i]-=b;
            soldeSuffisant.signalAll();
        }

    } finally {bankLock.unlock();

        } }

        public int size()
    {
        return nbcompte ;
    }

    public double getSoldeInit()
    {
        return soldeinit ;
    }
}
