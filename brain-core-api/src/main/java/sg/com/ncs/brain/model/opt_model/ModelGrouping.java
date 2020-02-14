package sg.com.ncs.brain.model.opt_model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.com.ncs.brain.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
@Table(name = "model_grouping", indexes = {
		@Index(name = "model_grouping_idx", columnList = "group_id,model_id", unique = true) })
public class ModelGrouping implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer model_id;
	private Integer group_id;

	@Embedded
	private DefaultColumns defaultColumns;

}