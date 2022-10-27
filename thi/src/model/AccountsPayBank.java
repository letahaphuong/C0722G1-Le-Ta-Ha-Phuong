package model;

public class AccountsPayBank extends AccountsBank {
    private String numberCard;
    private double moneyInAcc;

    public AccountsPayBank() {
    }

    public AccountsPayBank(String numberCard, double moneyInAcc) {
        this.numberCard = numberCard;
        this.moneyInAcc = moneyInAcc;
    }

    public AccountsPayBank(int idAcc, String codeAcc, String nameAcc,
                           String dateCre, String numberCard, double moneyInAcc) {
        super(idAcc, codeAcc, nameAcc, dateCre);
        this.numberCard = numberCard;
        this.moneyInAcc = moneyInAcc;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public double getMoneyInAcc() {
        return moneyInAcc;
    }

    public void setMoneyInAcc(double moneyInAcc) {
        this.moneyInAcc = moneyInAcc;
    }

    @Override
    public String toString() {
        return "AccountsPayBank{" +super.toString()+
                "numberCard='" + numberCard + '\'' +
                ", moneyInAcc=" + moneyInAcc +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",getIdAcc(),getCodeAcc(),getNameAcc(),getDateCre(),getNumberCard(),getMoneyInAcc());
    }
}
