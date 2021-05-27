package cn.edu.niit.util;

import java.util.List;

/**
 * @ClassName PageBean
 * @Description TODO
 * @Author Mister-Lu
 * @Date 2021/5/26
 **/
public class PageBean<T> {

    private int start;    // 首页
    private int end;    // 尾页
    private int cur;    // 当前页
    private long total;    // 总记录数
    private List<T> rows;    // 记录的集合（查询出来的相应页的数据）

    public PageBean() {
    }

    public PageBean(int start, int end, int cur, long total, List<T> rows) {
        this.start = start;
        this.end = end;
        this.cur = cur;
        this.total = total;
        this.rows = rows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}


