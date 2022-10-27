package model;

public abstract class AccountsBank {
    public abstract String getInfo();

    private int idAcc;
    private String codeAcc;
    private String nameAcc;
    private String dateCre;

    public AccountsBank() {
    }

    public AccountsBank(int idAcc, String codeAcc, String nameAcc, String dateCre) {
        this.idAcc = idAcc;
        this.codeAcc = codeAcc;
        this.nameAcc = nameAcc;
        this.dateCre = dateCre;
    }

    public int getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(int idAcc) {
        this.idAcc = idAcc;
    }

    public String getCodeAcc() {
        return codeAcc;
    }

    public void setCodeAcc(String codeAcc) {
        this.codeAcc = codeAcc;
    }

    public String getNameAcc() {
        return nameAcc;
    }

    public void setNameAcc(String nameAcc) {
        this.nameAcc = nameAcc;
    }

    public String getDateCre() {
        return dateCre;
    }

    public void setDateCre(String dateCre) {
        this.dateCre = dateCre;
    }

    @Override
    public String toString() {
        return
                "idAcc='" + idAcc + '\'' +
                        ", codeAcc='" + codeAcc + '\'' +
                        ", nameAcc='" + nameAcc + '\'' +
                        ", dateCre='" + dateCre
                ;
    }
}
