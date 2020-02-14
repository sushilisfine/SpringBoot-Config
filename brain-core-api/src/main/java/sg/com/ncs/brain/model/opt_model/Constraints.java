package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@Table(name = "constraints")
public class Constraints implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// private Integer model_id;
	private String constraintId;
	private Integer constraintNum;
	private String displayName;
	private Integer const_type_id;
	private Boolean status;

	private String scoreLevel;
	private String scoreWeight;

	@ManyToOne
	private Model model;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@OneToMany(mappedBy = "constraints")
	private List<ConstraintMatch> constraintMatch = new ArrayList<>();

	@OneToMany(mappedBy = "constraints")
	private List<ConstraintParamValue> constraintParamValue = new ArrayList<>();

	@ManyToOne
	private ConstraintType constraintType;

}