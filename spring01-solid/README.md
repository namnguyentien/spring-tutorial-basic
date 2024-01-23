# SOLID principles in Java
SOLID là 5 nguyên tắc được sử dụng trong OOP, giúp code trở nên chuyên nghiệp, dễ test, dễ bảo trì, mở rộng
SOLID bao gồm: 
* Single responsibility principle (S)
* Open/close principle (O)
* Liskov substitution principle (L)
* Interface segregation principle (I)
* Dependency inversion principle (D)
## 1. Single responsibility principle
* RULE: Một class chỉ NÊN giữ một trách nhiệm duy nhất ==> làm một việc duy nhât tức là chứa 1 hàm duy nhất hoặc thực hiện một chức năng duy nhất.
* WHY: Nếu 1 class chứa nhiều hàm thực hiện nhiều chức năng, sau này mở rộng thêm nhiều chức năng khác vì vậy việc kiểm soát code trở nên khó khăn, test khó khăn, code khó khăn, bảo trì khó khăn.
Ví dụ:
 ```java
class Dinner{
    public void eat(){
    }
    public void drink(){
    }
}
```
Ta nên tách thành 2 class
```java
class Eatable{
    public void eat(){
    }
    public void drink(){
    }
}
```
## 2. Open/close principle
* RULE: Có thể thoải mái mở rộng một class nhưng không được sửa đổi bên trong class đó.
* WHY: Hãy extend nó và cài đặt thêm chức năng mà ta muốn.
## 3. Liskov substitution principle
* RULE: Trong một chương trình, các object của class con có thể thay thế class cha mà không làm thay đổi tính đúng đắn của chương trình.
* WHY: ....
## 4. Interface segregation principle
* RULE: Thay vì dùng 1 interface lớn, ta nên tách chúng thành nhiều interface nhỏ, với nhiều mục đích cụ thể.
* WHY: Điều này rất đơn giản, giả sử có 1 interface mà có cả trăm phương thức bên trong khi ta muốn implement interface đó ta phải cài đè tất cả các hàm đó
==> rất bất tiện chưa kể đến việc ta chỉ muốn dùng 1 hàm của interface đó mà thôi mà phải cài đè tất cả thì không hợp lí chút nào
==> Vậy nên, nên tách thành các interface nhỏ với các chức năng riêng biệt, 1 function càng tốt (functional interface)
## 5. Dependency inversion
* RULE:
    1. Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả 2 nên phụ thuộc vào abstraction.
    2. Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại. (Các class giao tiếp với nhau thông qua interface, không phải thông qua implementation, tức là không thông qua class implement).
Ví dụ, ta có các class sau:
```java
class Travel{
    Car car = new Car();

    void startJourney(){
        car.move();
    }
}
class Car(){
    void move(){
        Sysem.out.println("Move by Car);
    }
}
class Train(){
    void move(){
        Sysem.out.println("Move by Train);
    }
}
```
Nếu như `Travel` bây giờ là tàu thì ta phải sửa code ==> rất bận tiện, không thể chấp nhận được.
===> Dùng interface chung là cách giải quyết: 
```java
interface Vehicle{
    void move();
}
class Train implements Vehicle(){
  @Override
    public void move() {
        System.out.println("Train moving");
    }
}
class Car1 implements Vehicle(){
    @Override
    public void move() {
        System.out.println("Car moving");
    }
}
class Travel{
    Vehicle vehicle;

    public Travel(Vehicle vehicle){// đây chính là dependency inversion, đảo ngược sự phụ thuộc
        this.vehicle = vehicle();
    }
    public void run(){
        this.vehicle.move();
    }
}
```
## Phân tích
1. `Travel` phụ thuộc vào phương tiện mà ta khai báo, cụ thể
       nó phụ thuộc vào `Car`.
       
    Thay vào đó ta sử dụng một `interface` đại diện cho cả          `Train` và `Car`. Trong            `Travel` sử dụng đa hình để khai        báo `Vehicle` và khi nào cần đến `Vehicle` ta sẽ           truyền         vào 1 `Vehicle` ở constructor(`inject` - tiêm vào).

    Vậy nên, đến bây giờ `Travel` không còn phụ thuộc vào           phương tiện truyền vào nữa,        khi phương tiện nào cần move        thì nó truyền vào, không cần quan tâm nó là loại nào.          Sau này chuyển từ `Car` sang `Train` hay ngược lại đi           nữa, cũng không cần vào code       để sửa.
    Đó chính là `Dependency inversion`

2. `Dependency inversion` là một nguyên lý thiết kế và viết         code, để triển khai nguyên         lý này ta có `Inversion of control` (IoC). IoC là một design pattern, còn để thực
    hiện hóa IoC trong code thì gọi là Dependency                   Injection(DI).

    Các dạng DI bao gồm: 
        **`Constructor injection`: Truyền vào constructor(như trên sử dụng).
        **`Setter injection`: Truyền vào `setter` để inject.
        **`Interface injection`: Class cần inject sẽ implement 1 interface. Interface này chứa 1
           hàm tên Inject. Container sẽ injection dependency vào 1 class thông qua việc gọi hàm               Inject của interface đó. Cách này rườm rà ít sử dụng. 
       

       
