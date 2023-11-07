package ap.quantas.com.eQApprovalDetailsService;

import java.math.BigDecimal;


public class LineItemTable {
    public LineItemTable() {
        super();
    }
    private BigDecimal linenumber;    
    private String linetype;    
    private String glcodecomb;

  

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public String getLinetype() {
        return linetype;
    }

    public void setGlcodecomb(String glcodecomb) {
        this.glcodecomb = glcodecomb;
    }

    public String getGlcodecomb() {
        return glcodecomb;
    }


    public void setLinenumber(BigDecimal linenumber) {
        this.linenumber = linenumber;
    }

    public BigDecimal getLinenumber() {
        return linenumber;
    }
}
