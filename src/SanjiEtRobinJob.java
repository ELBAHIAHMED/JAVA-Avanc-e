public class SanjiEtRobinJob implements Runnable{
     private int i;
     private CompteBanque compte = new CompteBanque();

    @Override
    public void run() {
        for(i=0;i<=6 ;i++ ){
            demandeRetrait(300);
        }


    }
    public void demandeRetrait(int somme){
        if (somme>this.compte.getSolde()){
            System.out.println("Pas assez d’argent pour "+Thread.currentThread().getName());
        }
        else{System.out.println(Thread.currentThread().getName() + "est sur le point de retirer.");


        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " reveillé.");
        compte.retirer(somme);
        System.out.println(Thread.currentThread().getName() + " à compléter le retrait");
    }

    }}


