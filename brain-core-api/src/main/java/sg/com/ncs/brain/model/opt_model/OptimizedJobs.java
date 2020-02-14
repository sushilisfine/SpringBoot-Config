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
import sg.com.ncs.brain.model.DefaultColumns;

@Entity
@Data
@NoArgsConstructor
//@Audited
@Table(name = "optimized_jobs")
public class OptimizedJobs implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer job_id;
	private String taskId;
	private String taskName;
	private String startDateTime;
	private String endDateTime;
	private Integer taskDuration;
	private Boolean resourceLocked;
	private Boolean startDateTimeLocked;
	private String customFieldList;
	private String serviceId;
	private String timeWindowId;
	private String resourceId;
	private String location;

	@Embedded
	private DefaultColumns defaultColumns;

	@ManyToOne
	private Jobs jobs;

}