package cn.edu.niit.entity;

/**
 * @ClassName ClassInfo
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/29
 **/
public class ClassInfo {
    private Integer cid;

    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}
