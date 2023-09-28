### Câu 1
Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế nào? Hãy giải thích rõ cần thì minh hoạ

Trả lời : 
1. Thuộc tính name trong annotation @Entity được sử dụng để xác định tên của đối tượng Java khi nó được ánh xạ vào một bảng trong cơ sở dữ liệu. Mặc định, tên của đối tượng Java được sử dụng làm tên bảng, nhưng có thể sử dụng thuộc tính name để chỉ định tên bảng tùy chỉnh.
Ví dụ:

```java
@Entity(name = "MyEntity")
public class MyEntity {
  
}

```
Trong ví dụ này, tên của bảng trong cơ sở dữ liệu sẽ là "MyEntity" thay vì tên mặc định được tạo từ tên lớp.
2. Thuộc tính name trong annotation @Table được sử dụng để xác định tên của bảng trong cơ sở dữ liệu. Sử dụng nó khi muốn đặt tên tùy chỉnh cho bảng mà đối tượng Java được ánh xạ vào.
Ví dụ:
```java
@Entity
@Table(name = "table_name")
public class MyEntity {
    
}

```
Trong ví dụ này, tên của bảng trong cơ sở dữ liệu sẽ là "table_name" thay vì tên mặc định được tạo từ tên lớp.
Tóm lại, khác biệt chính giữa name trong @Entity và name trong @Table là:

name trong @Entity xác định tên của đối tượng Java .
name trong @Table xác định tên của bảng trong cơ sở dữ liệu.

### Câu 2
Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?

Trả lời : 
Để bật chế độ debug cho câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, bạn có thể bổ sung thuộc tính sau vào tệp application.properties của ứng dụng Spring Boot:
spring.jpa.show-sql=true
Khi đặt giá trị của spring.jpa.show-sql thành true, Hibernate sẽ hiển thị câu lệnh SQL mà nó thực hiện trong quá trình thực thi lên console hoặc logs của ứng dụng. Điều này giúp theo dõi và debug các câu lệnh SQL một cách dễ dàng để kiểm tra xem chúng có hoạt động đúng như mong muốn hay không.



### Câu 3
Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính.

1. Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính
2. Tham số nào chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu
3. Tham số nào buộc trường không được null?
Trả lời:
Annotation `@Column` được sử dụng để cấu hình các thuộc tính của một cột trong cơ sở dữ liệu cho một trường của một entity (đối tượng Java) khi sử dụng JPA trong Spring Boot.

Dưới đây là các tham số trong `@Column` và cách chúng ảnh hưởng đến cột trong cơ sở dữ liệu:

1. **Thay đổi tên cột (Tên cột khác với tên thuộc tính):**
   - Để đặt tên tùy chỉnh cho cột trong cơ sở dữ liệu, ta có thể sử dụng tham số `name` của annotation `@Column`. Ví dụ:

   ```java
   @Column(name = "column_name")
   private String propertyName;
   ```

   Trong trường hợp này, tên cột trong cơ sở dữ liệu sẽ là "column_name" thay vì mặc định là tên thuộc tính "propertyName".

2. **Yêu cầu dữ liệu duy nhất :**
   - Để yêu cầu rằng giá trị trong cột phải là duy nhất (không được trùng lặp), ta có thể sử dụng tham số `unique` của annotation `@Column`. Ví dụ:

   ```java
   @Column(unique = true)
   private String propertyName;
   ```

   Tham số này đảm bảo rằng không có hai dòng trong cơ sở dữ liệu có giá trị trong cột này trùng nhau.

3. **Buộc trường không được null :**
   - Để buộc trường không được chấp nhận giá trị null, bạn có thể sử dụng tham số `nullable` của annotation `@Column` và đặt nó thành `false`. Ví dụ:

   ```java
   @Column(nullable = false)
   private String propertyName;
   ```
   Tham số này đảm bảo rằng một giá trị phải được cung cấp cho trường này khi thêm dữ liệu mới vào cơ sở dữ liệu; nếu không, nó sẽ gây ra lỗi hoặc ngoại lệ.

### Câu 4
Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung

Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
Vậy 2 annotation này là gì

Để bắt được hai sự kiện trước khi đối tượng Entity lưu xuống CSDL (trước INSERT) hoặc trước khi đối tượng Entity được cập nhật xuống CSDL (trước UPDATE), ta có thể sử dụng hai annotation sau đây trong JPA:

1. **Ngay trước khi đối tượng Entity lưu xuống CSDL (trước INSERT):**
   - Để xử lý sự kiện này, ta có thể sử dụng annotation `@PrePersist`. Bất kỳ phương thức được đánh dấu bằng `@PrePersist` trong entity sẽ được gọi trước khi đối tượng này được lưu xuống CSDL (trước khi thực hiện lệnh INSERT).

   Ví dụ:

   ```java
   @Entity
   public class MyEntity {
       
       @PrePersist
       public void beforeInsert() {
           // Thêm logic xử lý trước khi thực hiện INSERT
       }
   }
   ```

2. **Ngay trước khi đối tượng Entity cập nhật xuống CSDL (trước UPDATE):**
   - Để xử lý sự kiện này, ta có thể sử dụng annotation `@PreUpdate`. Bất kỳ phương thức được đánh dấu bằng `@PreUpdate` trong entity sẽ được gọi trước khi đối tượng này được cập nhật trong CSDL (trước khi thực hiện lệnh UPDATE).

   Ví dụ:

   ```java
   @Entity
   public class MyEntity {
       

       @PreUpdate
       public void beforeUpdate() {
           // Thêm logic xử lý trước khi thực hiện UPDATE
       }
   }
   ```

Bằng cách sử dụng các annotation này, ta có thể thêm logic tùy chỉnh vào các phương thức được đánh dấu để thực hiện các hành động cần thiết trước khi lưu hoặc cập nhật đối tượng vào CSDL.

### Câu 5
JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?
   Trả lời:
   `JpaRepository` là một interface cung cấp bởi Spring Data JPA, không phải là một phần của thư viện JPA. Interface `JpaRepository` kế thừa từ một số interfaces khác trong Spring Data JPA, trong đó interface quan trọng nhất là `PagingAndSortingRepository`.

Cụ thể, `JpaRepository` được khai báo như sau:

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
    
}
```

Ta thấy, `JpaRepository` kế thừa `PagingAndSortingRepository`, và nó cung cấp một loạt các phương thức thuận tiện để thao tác với dữ liệu trong cơ sở dữ liệu sử dụng JPA. `PagingAndSortingRepository` cung cấp các phương thức liên quan đến phân trang và sắp xếp dữ liệu, trong khi `JpaRepository` bổ sung thêm các phương thức CRUD (Create, Read, Update, Delete) cho đối tượng được ánh xạ vào bảng trong cơ sở dữ liệu.

Nhờ vào `JpaRepository`, bạn có thể thực hiện các thao tác cơ bản với dữ liệu một cách dễ dàng mà không cần phải viết mã SQL trực tiếp.
    
### Câu 6
Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là Long, tuân thủ interface JpaRepository.

    Trả lời:
    public interface PostRepository extends JpaRepository<Post, Long> {}

### Câu 7
Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không?
Khi  đã sử dụng `@Id` để đánh dấu một cột là khóa chính (primary key), thì không cần phải sử dụng `@Column(unique = true)` để xác định rằng cột này là duy nhất (unique) nữa. Vì:

1. **Khóa chính là duy nhất (unique) theo mặc định:** Một khóa chính (primary key) trong cơ sở dữ liệu luôn phải đảm bảo tính duy nhất. Điều này có nghĩa rằng không thể có hai dòng có cùng giá trị trong cột khóa chính. Do đó, không cần phải sử dụng `@Column(unique = true)` cho một cột đã được đánh dấu là `@Id`, vì tính duy nhất đã được đảm bảo.

2. **@Id tự động đánh dấu cột là duy nhất:** Khi sử dụng `@Id` để đánh dấu một trường là khóa chính, Hibernate sẽ tự động coi đó là một cột duy nhất. Điều này có nghĩa là ta không cần phải xác định `@Column(unique = true)` cho nó.

Ví dụ:

```java
@Entity
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Đây là khóa chính, nó được coi là duy nhất mặc định.
    
    @Column(unique = true)
    private String email; // Duy nhất và đánh dấu explicit bằng @Column.
    
    
}
```

Trong ví dụ trên, trường `id` đã được đánh dấu là `@Id`, và nó được coi là duy nhất mặc định. Trường `email` cũng được đánh dấu là duy nhất bằng `@Column(unique = true)`, nhưng điều này có thể coi là lặp lại vì nó đã được bao gồm trong định nghĩa `@Id`.
    

### Câu 8
Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy viết các method trong interface EmployeeRespository để :

Tìm tất cả các Employee theo emailAddress và lastName
Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
Tìm tất cả các Employee theo fistName không phân biệt hoa thường

    Trả lời:

Dưới đây là cách viết các phương thức trong interface `EmployeeRepository` để thực hiện các yêu cầu của đề bài:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Tìm tất cả các Employee theo emailAddress và lastName
    List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);
    
    // Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
    List<Employee> findByFirstNameNotAndLastNameNot(String firstName, String lastName);
    
    // Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
    List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);
    
    // Tìm tất cả các Employee theo firstName không phân biệt hoa thường
    List<Employee> findByFirstNameIgnoreCase(String firstName);
}
```


### Câu 9
Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ
`@NamedQuery` và `@Query` là hai cách để định nghĩa các truy vấn tùy chỉnh trong JPA (Java Persistence API) cho các đối tượng entity. Chúng cho phép ta viết các truy vấn SQL hoặc JPQL (Java Persistence Query Language) riêng biệt và gắn chúng với entity để có thể sử dụng lại và thực hiện truy vấn dựa trên tên thay vì viết truy vấn từng lần.

Dưới đây là cách sử dụng của `@NamedQuery` và `@Query`:

1. **@NamedQuery**:
   - `@NamedQuery` cho phép đặt tên cho một truy vấn JPQL và gắn nó với một đối tượng entity bằng cách sử dụng annotation `@NamedQueries` trong entity class.

   Ví dụ:

   ```java
   @Entity
   @NamedQueries({
       @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
       @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
   })
   public class Employee {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       
       private String firstName;
       
       private String lastName;

       
   }
   ```

   - Ta có thể sử dụng các `NamedQuery` này trong `EntityManager` để thực hiện truy vấn.

   Ví dụ sử dụng `@NamedQuery`:

   ```java
   TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByLastName", Employee.class);
   query.setParameter("lastName", "Smith");
   List<Employee> employees = query.getResultList();
   ```

2. **@Query**:
   - `@Query` cho phép ta định nghĩa truy vấn JPQL trực tiếp bằng cách sử dụng annotation `@Query` trên một phương thức trong repository interface.

   Ví dụ:

   ```java
   public interface EmployeeRepository extends JpaRepository<Employee, Long> {
       @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName")
       List<Employee> findByLastName(@Param("lastName") String lastName);
   }
   ```

   - Sau đó, ta có thể gọi phương thức `findByLastName` trong `EmployeeRepository` để thực hiện truy vấn.

   Ví dụ sử dụng `@Query`:

   ```java
   List<Employee> employees = employeeRepository.findByLastName("Smith");
   ```

### Câu 10
Dưới đây là một ví dụ về cách sử dụng sorting (sắp xếp) và paging (phân trang) khi truy vấn đối tượng `Employee` bằng Spring Data JPA:

Giả sử ta có một `EmployeeRepository` như sau:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
}
```

Bây giờ, ta muốn thực hiện một truy vấn phân trang cho tất cả các nhân viên, sắp xếp theo trường `lastName` tăng dần và giới hạn kết quả trả về từ trang thứ 2 (pageIndex = 1) với kích thước trang là 10 (pageSize = 10).

```java


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> findAllEmployees(int pageIndex, int pageSize) {
        // Định nghĩa phân trang và sắp xếp
        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by("lastName").ascending());

        // Thực hiện truy vấn phân trang
        return employeeRepository.findAll(pageable);
    }
}
```

Trong ví dụ trên, `PageRequest.of(pageIndex, pageSize, Sort.by("lastName").ascending())` được sử dụng để định nghĩa phân trang và sắp xếp. Đối số `pageIndex` đại diện cho trang cần lấy (0 là trang đầu tiên), `pageSize` là kích thước trang , và `Sort.by("lastName").ascending()` là sắp xếp theo trường `lastName` tăng dần.

    

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
