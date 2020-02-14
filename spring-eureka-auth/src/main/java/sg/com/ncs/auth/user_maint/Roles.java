package sg.com.ncs.auth.user_maint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "roles")
@ToString(exclude = { "permissions", "userRoles" })
//@Audited
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Integer power;

	@OneToMany(mappedBy = "roles")
	// @NotAudited
	private List<UserRole> userRoles = new ArrayList<>();

	@OneToMany(mappedBy = "role")
	// @Audited
	private List<Permissions> permissions = new ArrayList<>();

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	private Boolean status;

}