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
