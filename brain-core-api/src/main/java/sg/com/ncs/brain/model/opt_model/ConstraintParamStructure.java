package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Table(name = "constraint_param_structures")
public class ConstraintParamStructure implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer const_param_id;
	private Integer seqNo;

	@Column(name = "\"key\"")
	private String key;
	private String value;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private ConstraintParam constraintParam;

	@OneToMany(mappedBy = "constraintParamStructure")
	private List<ConstraintParamValue> constraintParamValue = new ArrayList<>();

}