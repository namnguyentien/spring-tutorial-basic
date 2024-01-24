# CÁCH SPRING TẠO RA MỘT BEAN

Một chương trình java bình thường khi thực hiện chạy chương trình, hàm `main` được gọi tới và thực thi. Nó sẽ chạy lần lượt từ trên xuống dưới, thực hiện công việc khởi tạo đối tượng, gọi hàm, xem xét các thuộc tính con bên trong hay các thuộc tính của cha nó mà nó kế thừa, hoặc các mối quan hệ ràng buộc như `extend`,`implemants`, `association`,...

Spring cũng vậy, nhưng khác ở chỗ, các công việc đó là do Spring Container làm. Nó sẽ tạo các `instances`(`beans`), các mối quan hệ giữa các `beans`, các sự phụ thuộc được inject.

Spring sẽ sử dụng `Java reflection` để thực hiện việc này,ta sẽ không phải tự tạo bằng tay(từ khóa `new`) như trước nữa.

Trình tự mà Spring tạo ra một bean gồm các bước: 
  
  1. Spring sẽ load ra các bean mà ta cấu hình trong file config và bắt đầu khởi tạo bean.
  
  2. Khi đọc tới cấu hình của các thuộc tính trong bean và inject chúng (sử dụng constructor hoặc setter). Nếu có thuộc tính tham chiếu tới 1 bean khác thì nó sẽ khởi tạo bean được tham chiếu tới trước, sau đó inject vào thuộc tính cảu bean mà nó đang khởi tạo. VD: Khi khởi tạo bean `student`, Spring sẽ đọc các thuộc tính bên trong bean đó và inject. Nhưng khi đọc tới thuộc tính clazz, nó tham chiếu tới bean clazz được định nghĩa trước đó. Thì Spring sẽ tạo bean Clazz trước sau đó inject vào bean student. Nếu tạo bean clazz thất bại thì tạo bean student cũng toang.
  
  3. Nếu bean của ta `implement` bất kỳ interface nào như là `BeanNameAware`, hoặc `BeanFactoryAware` thì các phương thức tương ứng cài đè sẽ được gọi.
 
  4. Spring gọi tới `BeanPostProcessor`, nếu bean của ta có mối liên kết với nó.

  5. Phương thức `init()` sẽ được thực hiện, nếu mà chúng ta cài đè nó.

  6. `Post-initialization` sẽ được thực hiện (một hành động hậu xử lý khi bean được khởi tạo).
