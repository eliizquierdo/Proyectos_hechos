package modelo.vo;

public class DictaVO {
    private int ciP;
    private int idP;
    public DictaVO(int ciP, int idP) {
        this.ciP = ciP;
        this.idP = idP;
    }

    public int getCiP() {
        return ciP;
    }
    public void setCiP(int ciP) {
        this.ciP = ciP;
    }

    public int getIdP() {
        return idP;
    }
    public void setIdP(int idP) {
        this.idP = idP;
    }
}
