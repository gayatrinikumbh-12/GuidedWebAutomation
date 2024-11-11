package models;

import lombok.Data;

@Data

@Builder(toBuilder = true) @NoArgsConstructor @AllArgsConstructor 
public class Product {
    private String name;
    private String searchKeyword;
    private String price;
    private String brand;
    private String size;
    private String color;
    private String description;
    private String quantity;
    
    public Product init() {
        return this.toBuilder().searchKeyword("Jeans").name("Belted Jeans").size("3").color("Sand Stone").quantity("1").build();
    }
    
    public void assertThatNameSizeColorAreSame(Product that) {
        Assertions.assertThat(this.getName()).isEqualTo(that.getName());
        Assertions.assertThat(this.getSize()).isEqualTo(that.getSize());
        Assertions.assertThat(this.getColor()).isEqualTo(that.getColor());
}
