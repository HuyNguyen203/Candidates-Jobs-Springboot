# LAB 05 - LẬP TRÌNH WWW (JAVA)
## Sinh viên thực hiện
- **Họ và tên:** Nguyễn Lê Nhật Huy
- **MSSV:** 21128101
## Nội dung trong bài tập
- Tạo các entities được ánh xạ từ cơ sở dữ liệu có sẳn
- Tạo website người dùng có thể đăng ký tài khoản cho candidate hoặc company
- Thực hiện các chức năng: chỉnh sửa thông tin cá nhân, tìm kiếm công việc và ứng viên phù hợp
## Tech stack
- **Frontend:** `HTML, CSS, JavaScript, Bootstrap`
- **Backend:** `Java, Spring Boot, Spring Data JPA, MySQL`
- **Database:** `HeidiSQL`
- **IDE:** `IntelliJ IDEA`
- **Version control:** `Git, GitHub`
- **Documentation:** `Markdown`
- **Others:** `Lombok`
## Tính năng
- Giao diện khi vào địa chỉ localhost:8080
  ![image](https://github.com/user-attachments/assets/c2b628db-dc50-4f83-8186-686e404f3246)
- Chọn loại tài khoản để đăng ký
  ![image](https://github.com/user-attachments/assets/aec34659-56c7-4f20-b361-d233ef28c056)
- Đăng ký cho ứng viên
  ![image](https://github.com/user-attachments/assets/a0a47618-2fad-44f3-a590-920269090105)
- Đăng ký cho công ty tuyển dụng
  ![image](https://github.com/user-attachments/assets/2acc9367-034c-409c-969f-dcb3023551d1)
- Đăng nhập
  ![image](https://github.com/user-attachments/assets/f9899a09-9ea9-44f7-a3e0-f5de717728e9)
- Giao diện cho ứng viên
  ![image](https://github.com/user-attachments/assets/f681ff89-5fad-489a-b19d-6a28fe323116)
- Xem Profile cá nhân của tài khoản
  ![image](https://github.com/user-attachments/assets/22c75f32-dc53-4f7b-b7b8-2ef9e9a5372b)
- Form thêm kinh nghiệm làm việc của ứng viên
  ![image](https://github.com/user-attachments/assets/39302230-711a-46fc-be5d-42a4d7cfd4bb)
- Form thêm kỹ năng làm việc của ứng viên
  ![image](https://github.com/user-attachments/assets/9bf97242-3b9c-48a6-93fd-294625bbbfeb)

- Thêm và chỉnh sửa các kinh nghiệm công việc cho ứng viên
## Hướng dẫn sử dụng
1. Clone project từ GitHub về máy tính bằng lệnh:
`https://github.com/HuyNguyen203/Candidates-Jobs-Springboot`
3. Mở project bằng IntelliJ IDEA (đảm bảo đã cài đặt plugin Lombok, Spring Boot, Spring Data JPA,...)
4. Mở HeidiSQL và tạo database có tên `blog` hoặc mở HeidiSQL và chạy file `Script.sql`
5. Chỉnh sửa thông tin kết nối database trong file `application.properties`
6. Chạy project và truy cập vào đường dẫn `http://localhost:8080/index`
7. Bắt đầu sử dụng các tính năng của ứng dụng
