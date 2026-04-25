package modelo.vo;

public class PracticanVO {
    private int ciA;
    private int idD;
    private int ciP;
    public PracticanVO(int ciA, int idD, int ciP) {
        this.ciA = ciA;
        this.idD = idD;
        this.ciP = ciP;
    }

    public int getCiA() {
        return ciA;
    }
    public void setCiA(int ciA) {
        this.ciA = ciA;
    }

    public int getIdD() {
        return idD;
    }
    public void setIdD(int idD) {
        this.idD = idD;
    }

    public int getCiP() {
        return ciP;
    }
    public void setCiP(int ciP) {
        this.ciP = ciP;
    }    
}
