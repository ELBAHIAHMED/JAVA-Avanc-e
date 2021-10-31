public class CompteBanque {
    private int solde=2000;
    public int getSolde(){
        return solde;
    }
    public void retirer(int somme){
        solde =solde-somme;
        System.out.println(solde);

    }
}
