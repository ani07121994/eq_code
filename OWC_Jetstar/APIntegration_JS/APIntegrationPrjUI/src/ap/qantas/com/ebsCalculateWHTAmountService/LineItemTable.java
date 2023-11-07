package ap.qantas.com.ebsCalculateWHTAmountService;

import java.math.BigDecimal;

public class LineItemTable {
    public LineItemTable() {
        super();
    }
    
    private String awtgroupname;
    private String awtdate;
    private BigDecimal lineamount;
    private BigDecimal orgid;
    private String invcurrencycode;
    private BigDecimal suppliersiteid;  
    private String gldate;


    public void setAwtgroupname(String awtgroupname) {
        this.awtgroupname = awtgroupname;
    }

    public String getAwtgroupname() {
        return awtgroupname;
    }

    public void setAwtdate(String awtdate) {
        this.awtdate = awtdate;
    }

    public String getAwtdate() {
        return awtdate;
    }

    public void setLineamount(BigDecimal lineamount) {
        this.lineamount = lineamount;
    }

    public BigDecimal getLineamount() {
        return lineamount;
    }

    public void setOrgid(BigDecimal orgid) {
        this.orgid = orgid;
    }

    public BigDecimal getOrgid() {
        return orgid;
    }

    public void setInvcurrencycode(String invcurrencycode) {
        this.invcurrencycode = invcurrencycode;
    }

    public String getInvcurrencycode() {
        return invcurrencycode;
    }

    public void setSuppliersiteid(BigDecimal suppliersiteid) {
        this.suppliersiteid = suppliersiteid;
    }

    public BigDecimal getSuppliersiteid() {
        return suppliersiteid;
    }

    public void setGldate(String gldate) {
        this.gldate = gldate;
    }

    public String getGldate() {
        return gldate;
    }
}
