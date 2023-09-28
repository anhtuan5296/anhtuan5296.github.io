### Câu 1
Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế nào? Hãy giải thích rõ cần thì minh hoạ

    Trả lời: 
    Annotation @Entity được sử dụng để đánh dấu một lớp Java là một thực thể (entity) trong cơ sở dữ liệu. Thuộc tính name của @Entity được sử dụng để xác định tên của thực thể trong cơ sở dữ liệu
        
    Annotation @Table được sử dụng để xác định tên bảng trong cơ sở dữ liệu mà thực thể được ánh xạ tới. Thuộc tính name của @Table được sử dụng để chỉ định tên của bảng

### Câu 2
Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?

    Trả lời:
    Để debug câu lệnh SQL mà Hibernate sinh ra trong quá trình thực thi cần bổ sung lệnh:
    spring.jpa.properties.hibernate.show_sql=true
    spring.jpa.properties.hibernate.format_sql=true

### Câu 3
Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính.

Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính
Tham số nào chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu
Tham số nào buộc trường không được null?

    Trả lời:
    1. Tham số name cho phép đổi tên của cột trong cơ sở dữ liệu nếu muốn khác với tên của thuộc tính.
    2. Tham số unique chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu trong cột. Khi đặt unique thành true, Hibernate sẽ tạo một ràng buộc duy nhấtcho cột trong cơ sở dữ liệu.
    3. Tham số nullable chỉ định xem trường có cho phép giá trị null hay không. Khi đặt nullable thành false, Hibernate sẽ tạo ra một ràng buộc không cho phép giá trị null trong cột cơ sở dữ liệu.

### Câu 4
Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung

Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
Vậy 2 annotation này là gì

    Trả lời:
    Để bắt được hai sự kiện trước khi đối tượng Entity lưu xuống CSDL và trước khi đối tượng Entity được cập nhật xuống CSDL, JPA cung cấp hai annotation tương ứng: @PrePersist và @PreUpdate.

### Câu 5
JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?

    Trả lời:
    Interface JpaRepository trong thư viện JPA không kế thừa từ một interface cụ thể. Thay vào đó, nó là sự kết hợp của hai interface: CrudRepository và PagingAndSortingRepository.

    CrudRepository: Đây là một interface trong JPA cung cấp các phương thức cơ bản cho các thao tác CRUD (Create, Read, Update, Delete) với đối tượng Entity. Các phương thức được cung cấp bao gồm: save, findById, findAll, delete, và nhiều hơn nữa.
    
    PagingAndSortingRepository: Đây cũng là một interface trong JPA, mở rộng CrudRepository và cung cấp hỗ trợ phân trang và sắp xếp kết quả truy vấn. Nó bao gồm các phương thức như findAll(Pageable), findAll(Sort), và các phương thức liên quan đến phân trang và sắp xếp.

### Câu 6
Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là Long, tuân thủ interface JpaRepository.

    Trả lời:
    public interface PostRepository extends JpaRepository<Post, Long> {}

### Câu 7
Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không?

    Trả lời:
    Khi đã chọn một cột là trường Identity bằng cách sử dụng annotation @Id thì không cần phải sử dụng annotation @Column(unique=true) để xác định cột đó là duy nhất.

### Câu 8
Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy viết các method trong interface EmployeeRespository để :

Tìm tất cả các Employee theo emailAddress và lastName
Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
Tìm tất cả các Employee theo fistName không phân biệt hoa thường

    Trả lời:

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);

        List<Employee> findByFirstNameOrLastName(List<String> firstNames, List<String> lastNames);

        List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

        List<Employee> findByFirstNameIgnoreCase(String firstName);
    }

### Câu 9
Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ

    Trả lời:
    1. @NamedQuery:
    - @NamedQuery được sử dụng để định nghĩa một câu truy vấn tùy chỉnh bằng cách gắn nó vào đối tượng Entity.
    - Câu truy vấn được định nghĩa bên ngoài trong các file XML hoặc trong cùng file Entity, sử dụng ngôn ngữ truy vấn tương ứng cho cơ sở dữ liệu (ví dụ như JPQL hoặc SQL).
    - Cú pháp @NamedQuery như sau: @NamedQuery(name = "NamedQueryName", query = "SELECT e FROM EntityName e WHERE e.property = :propertyValue").
    - name: Tên duy nhất của câu truy vấn.
    - query: Nội dung câu truy vấn.
    - Để sử dụng @NamedQuery, bạn có thể gọi nó thông qua EntityManager hoặc EntityManagerFactory và truyền tên của câu truy vấn đã định nghĩa.
    
Ví dụ:
    
    @Entity
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    public class Employee {

    }

    2. @Query:
    - @Query được sử dụng để viết câu truy vấn tùy chỉnh trực tiếp trong phương thức của interface repository.
    - Câu truy vấn được viết bằng ngôn ngữ truy vấn tương ứng cho cơ sở dữ liệu (ví dụ như JPQL hoặc SQL).
    - Cú pháp @Query như sau: @Query("SELECT e FROM EntityName e WHERE e.property = :propertyValue").
    - value (hoặc query): Nội dung câu truy vấn.
    - Để sử dụng @Query, bạn có thể gọi phương thức tương ứng trên interface repository.

Ví dụ:

    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
        List<Employee> findByLastName(String lastName);
    }

### Câu 10
Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên

    Trả lời:
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(PageRequest pageRequest);

    List<Employee> findAll(Sort sort);
    }

### Câu 11
Có 3 Entity Product.java và Category.java và Tag.java

Hãy bổ sung định nghĩa quan hệ One to Many giữa bảng Category (One) – Product (Many). Chú ý khi một Category xoá, thì không được phép xoá Product, mà chỉ set thuộc tính Category của Product là null.
Hãy bổ sung định nghĩa quan hệ Many to Many giữa bảng Tag(Many) – Product(Many).

Trả lời:
```java
//1. Category Class:
package org.example.Ex11;
    
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    
    import java.util.List;
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name="category")
    public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> products;
    }
```
    
    

    
```java
//2. Product Class:

       package org.example.Ex11;

       import jakarta.persistence.*;
       import lombok.AllArgsConstructor;
       import lombok.Getter;
       import lombok.NoArgsConstructor;
       import lombok.Setter;
    
       import java.util.List;
    
       @Getter
       @Setter
       @NoArgsConstructor
       @AllArgsConstructor
       @Entity
       @Table(name="product")
    
       public class Product {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String name;

       @ManyToOne
       @JoinColumn(name = "category_id")
       private Category category;

       @ManyToMany
       @JoinTable(
               name = "product_tag",
               joinColumns = @JoinColumn(name = "product_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id")
       )
       private List<Tag> tags;
       }

```
```java
//3. Tag Class:

          package org.example.Ex11;

           import jakarta.persistence.*;
           import lombok.AllArgsConstructor;
           import lombok.Getter;
           import lombok.NoArgsConstructor;
           import lombok.Setter;
           import org.example.Ex11.Product;
        
           import java.util.List;
        
           @Getter
           @Setter
           @NoArgsConstructor
           @AllArgsConstructor
           @Entity
           @Table(name="tag")
           public class Tag {
           @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           private Long id;
    
           private String name;
    
           @ManyToMany(mappedBy = "tags")
           private List<Product> products;
   }
```
   

### Câu 12
```java
package org.example.Ex12;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
```
```java
package org.example.Ex12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
}

```

```java
package org.example.Ex12;

import lombok.RequiredArgsConstructor;

public interface UserProjection {
    Long getId();
    String getName();
    String getEmail();


    @RequiredArgsConstructor
    class UserProjectionImpl implements UserProjection{

        @Override
        public Long getId() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getEmail() {
            return null;
        }

        static  UserProjection of(User user){
            return new UserProjectionImpl();
        }
    }
}

```

```java
package org.example.Ex12;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Method Query
    List<UserDto> findAllBy();

    // JPQL Query
    @Query("SELECT new org.example.Ex12.UserDto(u.id, u.name, u.email) FROM User u")
    List<UserDto> findAllUsers();

    // Native Query
    @Query(value = "SELECT id, name, email FROM users", nativeQuery = true)
    List<UserDto> findAllUsersNQ();

    // Projection
    List<UserProjection> findAllByProjection();
}

```

### Câu 13
Trả lời:
```java
package org.example.Ex13;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="post")
public class Post {
    @Id
    private String id;
    private String title;

    public void setId(String id) {
        // Kiểm tra nếu ID đã được set thì không thực hiện việc set lại
        if (this.id == null) {
            this.id = id;
        }
    }
    @PrePersist
    public void generateId() {
        // Kiểm tra nếu id chưa được set thì sinh id ngẫu nhiên
        if (this.id == null) {
            // Sinh id ngẫu nhiên
            UUID uuid = UUID.randomUUID();
            this.id = uuid.toString();
        }
    }
}
```
