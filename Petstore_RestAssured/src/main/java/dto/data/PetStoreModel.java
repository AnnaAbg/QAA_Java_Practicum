package dto.data;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a pet store order with various attributes such as id, petId, quantity, ship date, status, and completion status.
 *
 * <p>This class is annotated with Lombok annotations to generate boilerplate code for
 * data manipulation, building, and equality checks.</p>
 *
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class PetStoreModel {

	@JsonProperty("id")
	private final String id;

	private final int petId;
	private final int quantity;
	private final String shipDate;
	private final boolean complete;
	private final String status;

	public String getId() {
		return id;
	}

	public String getShipDate() {
		return shipDate;
	}

	public String getStatus() {
		return status;
	}
}