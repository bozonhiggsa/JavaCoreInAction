package net.core.tutorial.proficient._03_XML.entity;

public class Transport {

    protected String content;

    protected String voucher_include;

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }

    public String getVoucher_include() {
        return voucher_include;
    }

    public void setVoucher_include(String voucher_include) {
        this.voucher_include = voucher_include;
    }

    @Override
    public String toString() {
        return content;
    }
}
