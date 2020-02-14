package sg.com.ncs.auth.user_maint;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sg.com.ncs.auth.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_roles")
@ToString(exclude = { "roles", "user" })
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn
	private Roles roles;

	@Id
	@ManyToOne
	@JoinColumn
	private User user;

	@Embedded
	private DefaultColumns defaultColumns;

}