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
@Table(name = "constraint_params")
public class ConstraintParam implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer const_type_id;
	private String parameterId;
	private String parameterType;
	private String parameterNum;
	private String name;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private ConstraintType constraintType;

	@OneToMany(mappedBy = "constraintParam")
	private List<ConstraintParamStructure> constraintParamStructure = new ArrayList<>();
	
	@OneToMany(mappedBy = "constraintParam")
	private List<ConstraintParamValue> constraintParamValue = new ArrayList<>();

}