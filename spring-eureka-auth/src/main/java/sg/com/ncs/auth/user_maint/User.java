package sg.com.ncs.auth.user_maint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sg.com.ncs.auth.model.CreatorColumns;
import sg.com.ncs.auth.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"userGroups", "userRoles"})
//@Audited
@Table(name = "users", indexes = { @Index(name = "users_idx", columnList = "username", unique = true) })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String name;
	private String fullname;

	private String duty_title;
	private String email;
	private String password;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	@OneToMany(mappedBy = "user")
	// @NotAudited
	private List<UserGroups> userGroups = new ArrayList<>();

	// @NotAudited
	/* @OneToMany(mappedBy = "user") */
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles = new ArrayList<>();

}