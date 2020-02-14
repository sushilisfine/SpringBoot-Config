package sg.com.ncs.auth.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class DefaultColumns implements Serializable {

	private static final long serialVersionUID = 1196393228030355699L;
	@Column(name = "createdAt", nullable = false)
	private LocalDate createdAt;
	@Column(name = "updatedAt", nullable = false)
	private LocalDate updatedAt;

}
