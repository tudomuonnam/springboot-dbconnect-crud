Thêm JWT vào dự án

1. Khai báo addon
## Thêm addon vào file `pom.xml`
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```
## Add secret string to `application.property`
```properties
jwt.secret=notsecret
```
2. Tạo database user. Thêm dịch vụ đọc ghi sửa xóa
- Tạo model `UsesrDTO.java`
```java
public class UserDTO {
    private String username;
    private String password;
// Them public + Get & set
```

3. Thêm controller jwt & các hàm tiện ích đi kèmUserDTO

Bắt đầu từ class `JwtAuthenticationController`
Tiếp theo, vì classy này cần 2 class khác là `jwtTokenUtil`, `JwtUserDetailsService`. Viết tiếp 2 hàm này
23:06: Đi ngủ mai viết tiếp
