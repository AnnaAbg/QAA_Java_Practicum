package dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Represents a pet with various attributes such as id, category, name, photo URLs, tags, and status.
 * <p>
 * This class is annotated with Lombok annotations to generate boilerplate code for
 * data manipulation, building, and equality checks.
 * </p>
 *
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class PetModel {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("category")
    private final CategoryAndTagsItem category;

    @JsonProperty("name")
    private final String name;

    private final List<String> photoUrls;
    private final List<CategoryAndTagsItem> tags;
    private final String status;

    @Data
    @Builder
    public static class CategoryAndTagsItem {
        private final long id;
        private final String name;
    }
}