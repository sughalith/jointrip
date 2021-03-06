package pl.jointrip.models.entities.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "user_role")
@IdClass(UserRolePK.class)
public class UserRole {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "user_id")
    private int userId;
    @Id@Column(name = "role_id")
    private int roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return userId == userRole.userId &&
                roleId == userRole.roleId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, roleId);
    }
}
