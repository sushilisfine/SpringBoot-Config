package sg.com.ncs.auth.user_maint;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "permissions")
@ToString(exclude = { "role" })
public class Permissions implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer level;
	private String title;

	@ManyToOne
	private Roles role;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean status;

}