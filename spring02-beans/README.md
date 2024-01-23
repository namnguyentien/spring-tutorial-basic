#SPRING BEANS
#1. Beans
* Là các object trong spring, được khởi tạo thông qua IoC Container. Các bean được định nghĩa trong file applicationContext.xml và được đọc ra như trong hàm main.
* `Context` (ngữ cảnh) trong spring là phạm vi hoạt động của spring, các `bean` được quản lý bởi IoC trong Context của chương trình. Spring sẽ tự tạo các bean khi cần thiết mà ta không phải tự tay khởi tạo `Message m = new Message();` như trên nữa, mà Spring sẽ tự động khởi tạo, inject các thành phần cần thiết.
