import com.ocelot.constant.CellInfo;

public class MainClass {

    @CellInfo
    private int a;
    private String b;

    public static void main(String[] args) {
        MainClass.class.getDeclaredFields();
        MainClass.class.getDeclaredAnnotations();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
