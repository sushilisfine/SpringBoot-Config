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
//@Audited
@Table(name = "\"groups\"")
@ToString(exclude = { "userGroups" })
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * private Integer role_id; private Integer level;
	 */

	private String name;
	// private String title;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	// @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

	// @NotAudited
	@OneToMany(mappedBy = "group")
	private List<UserGroups> userGroups = new ArrayList<>();

}