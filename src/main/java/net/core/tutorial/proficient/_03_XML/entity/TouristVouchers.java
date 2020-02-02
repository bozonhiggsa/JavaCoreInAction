package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "vouchers" })
@XmlRootElement(name = "TouristVouchers")
public class TouristVouchers {

    @XmlElement(name = "TouristVoucher", required = true)
    protected List<TouristVoucher> vouchers;

    public List<TouristVoucher> getVouchers() {
        if (vouchers == null)
            vouchers = new ArrayList<TouristVoucher>();
        return vouchers;
    }

    @Override
    public String toString() {
        if (vouchers == null || vouchers.size() == 0)
            return "TouristVouchers contains no vouchers";
        StringBuilder result = new StringBuilder();
        for (TouristVoucher voucher : vouchers){
            result.append(voucher).append('\n');
        }
        return result.toString();
    }
}
