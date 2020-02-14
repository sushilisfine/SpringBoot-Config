package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.CreatorColumns;
import sg.com.ncs.brain.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@Table(name = "model_access")
public class ModelAccess implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// private Integer model_id;
	private Integer acc_type_id;
	private Integer target_id;
	private Integer status;

	@Embedded
	private CreatorColumns creator;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private AccessType accessType;

	@ManyToOne
	private Model model;

}