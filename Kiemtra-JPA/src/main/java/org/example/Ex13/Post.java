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