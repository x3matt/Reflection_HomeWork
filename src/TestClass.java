
import java.util.Objects;

public class TestClass {
    @Deprecated
    private Integer num;
    @Deprecated
    private String name;
    private boolean flag;

    public TestClass(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    public TestClass() {
    }

    public Integer getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public boolean getFlag() {
        return flag;
    }
    @Deprecated
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestClass)) return false;
        TestClass testClass = (TestClass) o;
        return getFlag() == testClass.getFlag() &&
                getNum().equals(testClass.getNum()) &&
                getName().equals(testClass.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNum(), getName(), getFlag());
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
