import java.util.Date;

public class FuCached {
    private static FuCached instance;
    private Object data;
    Date expiredDate;

    public FuCached(Object data, Date expiredDate) {
        this.data = data;
        this.expiredDate = expiredDate;
    }

    public Object getObject() {
        return data;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }
}