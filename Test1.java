import java.util.concurrent.Callable;

public class Test1 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.plugin(new UDisk());
        computer.plugin(new PrintDisk());
    }
}
interface USB{
    public void setup();
    public void work();
}
class Computer{
    public void plugin(USB usb){
        usb.setup();
        usb.work();
    }
}
class UDisk implements USB{
    public void setup(){
        System.out.println("安装u盘驱动");
    }
    public void work() {
        System.out.println("u盘开始工作");
    }
}
class PrintDisk implements USB{
    public void setup(){
        System.out.println("安装打印机驱动");
    }
    public void work() {
        System.out.println("打印机开始工作");
    }
}
