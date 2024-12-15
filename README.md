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
- Đăng ký, đăng nhập tài khoản.
- Thêm, chỉnh sửa các kỹ năng cho ứng viên
- Thêm và chỉnh sửa các kinh nghiệm công việc cho ứng viên
## Hướng dẫn sử dụng
1. Clone project từ GitHub về máy tính bằng lệnh:
`https://github.com/HuyNguyen203/Candidates-Jobs-Springboot`
3. Mở project bằng IntelliJ IDEA (đảm bảo đã cài đặt plugin Lombok, Spring Boot, Spring Data JPA,...)
4. Mở HeidiSQL và tạo database có tên `blog` hoặc mở HeidiSQL và chạy file `Script.sql`
5. Chỉnh sửa thông tin kết nối database trong file `application.properties`
6. Chạy project và truy cập vào đường dẫn `http://localhost:8080/index`
7. Bắt đầu sử dụng các tính năng của ứng dụng