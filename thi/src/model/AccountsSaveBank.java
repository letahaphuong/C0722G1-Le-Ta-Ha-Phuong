package model;

public class AccountsSaveBank extends AccountsBank {
    private double moneyAcc;
    private String DateDeposit;
    private String interestRate;
    private String tenor;

    public AccountsSaveBank() {}

    public AccountsSaveBank(double moneyAcc, String dateDeposit, String interestRate, String tenor) {
        this.moneyAcc = moneyAcc;
        DateDeposit = dateDeposit;
        this.interestRate = interestRate;
        this.tenor = tenor;
    }

    public AccountsSaveBank(int idAcc, String codeAcc, String nameAcc,
                            String dateCre, double moneyAcc, String dateDeposit,
                            String interestRate, String tenor) {
        super(idAcc, codeAcc, nameAcc, dateCre);
        this.moneyAcc = moneyAcc;
        DateDeposit = dateDeposit;
        this.interestRate = interestRate;
        this.tenor = tenor;
    }

    public double getMoneyAcc() {
        return moneyAcc;
    }

    public void setMoneyAcc(double moneyAcc) {
        this.moneyAcc = moneyAcc;
    }

    public String getDateDeposit() {
        return DateDeposit;
    }

    public void setDateDeposit(String dateDeposit) {
        DateDeposit = dateDeposit;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    @Override
    public String toString() {
        return "AccountsSaveBank{" +super.toString()+
                "moneyAcc=" + moneyAcc +
                ", DateDeposit='" + DateDeposit + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", tenor='" + tenor + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getIdAcc(),getCodeAcc()
        ,getNameAcc(),getDateCre(),getMoneyAcc(),getDateDeposit(),
                getInterestRate(),getTenor());
    }
}
